drop database if exists controledemateriasis;

create database controledemateriasis;

use controledemateriasis;

-- categorias
insert into categorias (nomedacategoria, descricao)
values
('picareta', 'serve para cavar'),
('enchada', 'serve para capinar'),
('mangueira', 'molha as coisas');

select * from categorias;

-- materiais
insert into materiais (
    nomedomaterial,
    unidadee_medida,
    valor_unitario,
    quantidade,
    valor_minimo,
    valor_maximo,
    idcategoria
)
values
('picareta', 'un', 10.00, 50, 5, 100, 1),
('enchada', 'un', 10.00, 50, 5, 100, 2),
('mangueira', 'un', 10.00, 50, 5, 100, 3);

select * from materiais;

-- movimentação
insert into movimentacao (
    tipodemateriais,
    quantidademovimentacao,
    datademovimentacao,
    observacao,
    idmateriais
)
values
('entrada', 50, '2025-01-05', 'compra inicial', 1),
('entrada', 90, '2025-08-09', 'compra em lote', 2),
('saida', 20, '2026-03-01', 'compra para obra', 3);

select * from movimentacao;

-- view
create view vw_estoque as
select
    nomedomaterial as 'nome do material',
    quantidade,
    valor_unitario,
    quantidade * valor_unitario as 'valor total'
from materiais;

select * from vw_estoque;

-- valor total por categoria
select
    c.nomedacategoria,
    sum(m.quantidade * m.valor_unitario) as 'valor total categoria'
from materiais m
join categorias c on m.idcategoria = c.id
group by c.nomedacategoria;

-- movimentações de saída
select
    m.nomedomaterial,
    mv.quantidademovimentacao,
    mv.datademovimentacao,
    mv.observacao
from movimentacao mv
join materiais m on mv.idmateriais = m.id
where mv.tipodemateriais = 'saida'
order by mv.datademovimentacao desc;

-- estoque crítico
update materiais
set quantidade = 3
where nomedomaterial = 'picareta';

select
    nomedomaterial as 'nome do material',
    quantidade,
    valor_minimo,
    valor_maximo,
    case
        when quantidade <= valor_minimo then 'critico - minimo atingido'
        when quantidade >= valor_maximo then 'alerta - maximo atingido'
        else 'normal'
    end as status_estoque,
    round((quantidade / valor_maximo) * 100, 2) as percentual_nivel
from materiais
where quantidade <= valor_minimo
   or quantidade >= valor_maximo;

-- relatório de saídas
select
    m.nomedomaterial,
    sum(mv.quantidademovimentacao) as quantidade_total_saida,
    sum(mv.quantidademovimentacao * m.valor_unitario) as valor_total_saidas
from movimentacao mv
join materiais m on mv.idmateriais = m.id
where mv.tipodemateriais = 'saida'
and mv.datademovimentacao between '2025-01-01' and '2026-12-31'
group by m.id, m.nomedomaterial
order by quantidade_total_saida desc;

-- resumo de movimentações
select
    m.nomedomaterial,
    m.unidadee_medida,
    sum(
        case
            when mv.tipodemateriais = 'entrada'
            then mv.quantidademovimentacao
            else 0
        end
    ) as total_entradas,
    sum(
        case
            when mv.tipodemateriais = 'saida'
            then mv.quantidademovimentacao
            else 0
        end
    ) as total_saidas,
    sum(
        case
            when mv.tipodemateriais = 'entrada'
            then mv.quantidademovimentacao
            else -mv.quantidademovimentacao
        end
    ) as saldo_periodo,
    sum(
        case
            when mv.tipodemateriais = 'entrada'
            then mv.quantidademovimentacao * m.valor_unitario
            else 0
        end
    ) as valor_entradas,
    sum(
        case
            when mv.tipodemateriais = 'saida'
            then mv.quantidademovimentacao * m.valor_unitario
            else 0
        end
    ) as valor_saidas
from movimentacao mv
join materiais m on mv.idmateriais = m.id
where mv.datademovimentacao between '2025-01-01' and '2026-12-31'
group by m.id, m.nomedomaterial, m.unidadee_medida;

-- reposição de estoque
insert into movimentacao (
    tipodemateriais,
    quantidademovimentacao,
    datademovimentacao,
    observacao,
    idmateriais
)
values (
    'entrada',
    20,
    '2026-06-17',
    'reposicao de estoque',
    1
);

update materiais
set quantidade = quantidade + 20
where id = 1;