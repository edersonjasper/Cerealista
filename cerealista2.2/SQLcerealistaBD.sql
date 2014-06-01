
CREATE SEQUENCE public.categoria_cat_codigo_seq;

CREATE TABLE public.CATEGORIA (
                CAT_CODIGO INTEGER NOT NULL DEFAULT nextval('public.categoria_cat_codigo_seq'),
                CAT_DESCRICAO VARCHAR(30) NOT NULL,
                CONSTRAINT categoria_pk PRIMARY KEY (CAT_CODIGO)
);

insert into categoria(cat_codigo,cat_descricao)values(1,'Funcionário');
insert into categoria(cat_codigo,cat_descricao)values(2,'Cliente');
insert into categoria(cat_codigo,cat_descricao)values(3,'Forneccedor');
insert into categoria(cat_codigo,cat_descricao)values(4,'Transportadora');


ALTER SEQUENCE public.categoria_cat_codigo_seq OWNED BY public.CATEGORIA.CAT_CODIGO;

CREATE SEQUENCE public.forma_pagamento_for_pag_codigo_seq;

CREATE TABLE public.forma_pagamento (
                for_pag_codigo INTEGER NOT NULL DEFAULT nextval('public.forma_pagamento_for_pag_codigo_seq'),
                for_pag_descricao VARCHAR(20) NOT NULL,
                CONSTRAINT pk_forma_pagamento PRIMARY KEY (for_pag_codigo)
);


ALTER SEQUENCE public.forma_pagamento_for_pag_codigo_seq OWNED BY public.forma_pagamento.for_pag_codigo;

CREATE SEQUENCE public.unidade_medida_uni_med_codigo_seq;

CREATE TABLE public.unidade_medida (
                uni_med_codigo INTEGER NOT NULL DEFAULT nextval('public.unidade_medida_uni_med_codigo_seq'),
                uni_med_descricao VARCHAR(10) NOT NULL,
                CONSTRAINT pk_unidade_medida PRIMARY KEY (uni_med_codigo)
);


ALTER SEQUENCE public.unidade_medida_uni_med_codigo_seq OWNED BY public.unidade_medida.uni_med_codigo;

CREATE SEQUENCE public.produto_pro_codigo_seq;

CREATE TABLE public.produto (
                pro_codigo INTEGER NOT NULL DEFAULT nextval('public.produto_pro_codigo_seq'),
                uni_med_codigo INTEGER NOT NULL,
                pro_nome VARCHAR(40) NOT NULL,
                pro_estoque NUMERIC(10,3),
                CONSTRAINT pk_produto PRIMARY KEY (pro_codigo)
);


ALTER SEQUENCE public.produto_pro_codigo_seq OWNED BY public.produto.pro_codigo;

CREATE INDEX ix_fk_unidade_medida_produto
 ON public.produto USING BTREE
 ( uni_med_codigo );

CREATE SEQUENCE public.usuario_usu_codigo_seq;

CREATE TABLE public.usuario (
                usu_codigo INTEGER NOT NULL DEFAULT nextval('public.usuario_usu_codigo_seq'),
                usu_usuario VARCHAR(40) NOT NULL,
                usu_senha VARCHAR(20) NOT NULL,
                usu_nome VARCHAR(40) NOT NULL,
                usu_status VARCHAR(1) NOT NULL,
                CONSTRAINT pk_usuario PRIMARY KEY (usu_codigo)
);


ALTER SEQUENCE public.usuario_usu_codigo_seq OWNED BY public.usuario.usu_codigo;

CREATE SEQUENCE public.quebra_que_codigo_seq;

CREATE TABLE public.quebra (
                que_codigo INTEGER NOT NULL DEFAULT nextval('public.quebra_que_codigo_seq'),
                pro_codigo INTEGER NOT NULL,
                usu_codigo INTEGER NOT NULL,
                que_quantidade NUMERIC(10,2) NOT NULL,
                que_peso_unitario NUMERIC(10,3) NOT NULL,
                que_peso_total NUMERIC(10,3),
                que_data DATE NOT NULL,
                CONSTRAINT pk_quebra PRIMARY KEY (que_codigo)
);


ALTER SEQUENCE public.quebra_que_codigo_seq OWNED BY public.quebra.que_codigo;

CREATE INDEX ix_fk_produto_quebra
 ON public.quebra USING BTREE
 ( pro_codigo );

CREATE INDEX ix_fk_usuario_quebra
 ON public.quebra USING BTREE
 ( usu_codigo );

CREATE SEQUENCE public.saldo_caixa_sal_cai_codigo_seq;

CREATE TABLE public.saldo_caixa (
                sal_cai_codigo INTEGER NOT NULL DEFAULT nextval('public.saldo_caixa_sal_cai_codigo_seq'),
                sal_cai_valor NUMERIC(10,2) NOT NULL,
                sal_cai_data DATE NOT NULL,
                CONSTRAINT pk_saldo_caixa PRIMARY KEY (sal_cai_codigo)
);


ALTER SEQUENCE public.saldo_caixa_sal_cai_codigo_seq OWNED BY public.saldo_caixa.sal_cai_codigo;

CREATE SEQUENCE public.banco_ban_codigo_seq;

CREATE TABLE public.banco (
                ban_codigo INTEGER NOT NULL DEFAULT nextval('public.banco_ban_codigo_seq'),
                ban_nome VARCHAR(40) NOT NULL,
                CONSTRAINT pk_banco PRIMARY KEY (ban_codigo)
);


ALTER SEQUENCE public.banco_ban_codigo_seq OWNED BY public.banco.ban_codigo;

CREATE SEQUENCE public.cidade_cid_codigo_seq;

CREATE TABLE public.cidade (
                cid_codigo INTEGER NOT NULL DEFAULT nextval('public.cidade_cid_codigo_seq'),
                cid_nome VARCHAR(40) NOT NULL,
                cid_uf VARCHAR(2) NOT NULL,
                CONSTRAINT pk_cidade PRIMARY KEY (cid_codigo)
);


ALTER SEQUENCE public.cidade_cid_codigo_seq OWNED BY public.cidade.cid_codigo;

CREATE SEQUENCE public.tipo_telefone_tip_codigo_seq;

CREATE TABLE public.tipo_telefone (
                tip_codigo INTEGER NOT NULL DEFAULT nextval('public.tipo_telefone_tip_codigo_seq'),
                tip_descricao VARCHAR(20) NOT NULL,
                CONSTRAINT pk_tipo_telefone PRIMARY KEY (tip_codigo)
);


ALTER SEQUENCE public.tipo_telefone_tip_codigo_seq OWNED BY public.tipo_telefone.tip_codigo;

CREATE SEQUENCE public.caixa_cai_codigo_seq;

CREATE TABLE public.caixa (
                cai_codigo INTEGER NOT NULL DEFAULT nextval('public.caixa_cai_codigo_seq'),
                usu_codigo INTEGER NOT NULL,
                cai_valor_depositado NUMERIC(10,2) NOT NULL,
                cai_data DATE NOT NULL,
                CONSTRAINT pk_caixa PRIMARY KEY (cai_codigo)
);


ALTER SEQUENCE public.caixa_cai_codigo_seq OWNED BY public.caixa.cai_codigo;

CREATE INDEX ix_fk_usuario_caixa
 ON public.caixa USING BTREE
 ( usu_codigo );

CREATE SEQUENCE public.pessoa_pes_codigo_seq;

CREATE TABLE public.pessoa (
                pes_codigo INTEGER NOT NULL DEFAULT nextval('public.pessoa_pes_codigo_seq'),
                pes_nome VARCHAR(40) NOT NULL,
                pes_sexo CHAR(1) NOT NULL,
                pes_cpf_cnpj VARCHAR(20) NOT NULL,
                pes_ie VARCHAR(20),
                pes_endereco VARCHAR(40) NOT NULL,
                pes_bairro VARCHAR(40) NOT NULL,
                pes_numero INTEGER,
                pes_cep CHAR(9) NOT NULL,
                pes_nascimento DATE,
                cid_codigo INTEGER NOT NULL,
                usu_codigo INTEGER NOT NULL,
                pes_oculto VARCHAR(1),
                pes_tipo VARCHAR(1) NOT NULL,
                CONSTRAINT pk_pessoa PRIMARY KEY (pes_codigo)
);


ALTER SEQUENCE public.pessoa_pes_codigo_seq OWNED BY public.pessoa.pes_codigo;

CREATE INDEX ix_fk_cidade_pessoa
 ON public.pessoa USING BTREE
 ( cid_codigo );

CREATE INDEX ix_fk_usuario_pessoa
 ON public.pessoa USING BTREE
 ( usu_codigo );

CREATE SEQUENCE public.pessoa_categoria_pes_cat_codigo_seq;

CREATE TABLE public.pessoa_categoria (
                pes_cat_codigo INTEGER NOT NULL DEFAULT nextval('public.pessoa_categoria_pes_cat_codigo_seq'),
                pes_codigo INTEGER NOT NULL,
                CAT_CODIGO INTEGER NOT NULL,
                CONSTRAINT pk_pessoa_categoria PRIMARY KEY (pes_cat_codigo)
);


ALTER SEQUENCE public.pessoa_categoria_pes_cat_codigo_seq OWNED BY public.pessoa_categoria.pes_cat_codigo;

CREATE INDEX ix_fk_pessoa_pessoa_categoria
 ON public.pessoa_categoria USING BTREE
 ( pes_codigo );

CREATE SEQUENCE public.pagamento_funcionario_pag_fun_codigo_seq;

CREATE TABLE public.pagamento_funcionario (
                pag_fun_codigo INTEGER NOT NULL DEFAULT nextval('public.pagamento_funcionario_pag_fun_codigo_seq'),
                usu_codigo INTEGER NOT NULL,
                pes_cat_codigo INTEGER NOT NULL,
                pag_fun_valor NUMERIC(10,2) NOT NULL,
                pag_fun_data DATE NOT NULL,
                CONSTRAINT pk_pagamento_funcionario PRIMARY KEY (pag_fun_codigo)
);


ALTER SEQUENCE public.pagamento_funcionario_pag_fun_codigo_seq OWNED BY public.pagamento_funcionario.pag_fun_codigo;

CREATE INDEX ix_fk_pessoa_categoria_pagamento_funcionario
 ON public.pagamento_funcionario USING BTREE
 ( pes_cat_codigo );

CREATE INDEX ix_fk_usuario_pagamento_funcionario
 ON public.pagamento_funcionario USING BTREE
 ( usu_codigo );

CREATE SEQUENCE public.horas_trabalhadas_hor_tra_codigo_seq;

CREATE TABLE public.horas_trabalhadas (
                hor_tra_codigo INTEGER NOT NULL DEFAULT nextval('public.horas_trabalhadas_hor_tra_codigo_seq'),
                pes_cat_codigo INTEGER NOT NULL,
                hor_tra_valor_hora NUMERIC(10,2) NOT NULL,
                hor_tra_data DATE NOT NULL,
                hor_tra_descricao VARCHAR(100),
                hor_tra_valor_total NUMERIC(10,2) NOT NULL,
                hor_tra_horas_trabalhadas NUMERIC(10,2) NOT NULL,
                CONSTRAINT pk_horas_trabalhadas PRIMARY KEY (hor_tra_codigo)
);


ALTER SEQUENCE public.horas_trabalhadas_hor_tra_codigo_seq OWNED BY public.horas_trabalhadas.hor_tra_codigo;

CREATE INDEX ix_fk_pessoa_categoria_horas_trabalhadas
 ON public.horas_trabalhadas USING BTREE
 ( pes_cat_codigo );

CREATE SEQUENCE public.ordem_ord_codigo_seq;

CREATE TABLE public.ordem (
                ord_codigo INTEGER NOT NULL DEFAULT nextval('public.ordem_ord_codigo_seq'),
                usu_codigo INTEGER NOT NULL,
                ord_data DATE NOT NULL,
                ord_data_vencimento DATE NOT NULL,
                ord_peso_total NUMERIC(10,3),
                ord_valor_total NUMERIC(10,2),
                ord_fundo_rural NUMERIC(10,2),
                ord_desconto NUMERIC(10,2),
                ord_adiantamento NUMERIC(10,2),
                ord_valor_restante NUMERIC(10,2),
                ord_pago VARCHAR(1),
                pes_cat_codigo INTEGER NOT NULL,
                ord_aberta VARCHAR(1),
                CONSTRAINT pk_ordem PRIMARY KEY (ord_codigo)
);


ALTER SEQUENCE public.ordem_ord_codigo_seq OWNED BY public.ordem.ord_codigo;

CREATE INDEX ix_fk_pessoa_categoria_ordem
 ON public.ordem USING BTREE
 ( pes_cat_codigo );

CREATE INDEX ix_fk_usuario_ordem
 ON public.ordem USING BTREE
 ( usu_codigo );

CREATE SEQUENCE public.pagamento_ordem_pag_ord_codigo_seq;

CREATE TABLE public.pagamento_ordem (
                pag_ord_codigo INTEGER NOT NULL DEFAULT nextval('public.pagamento_ordem_pag_ord_codigo_seq'),
                usu_codigo INTEGER NOT NULL,
                ord_codigo INTEGER NOT NULL,
                for_pag_codigo INTEGER NOT NULL,
                pag_ord_valor NUMERIC(10,2) NOT NULL,
                pag_ord_data DATE NOT NULL,
                pag_ord_valor_acumulado NUMERIC(10,2),
                CONSTRAINT pk_pagamento_ordem PRIMARY KEY (pag_ord_codigo)
);


ALTER SEQUENCE public.pagamento_ordem_pag_ord_codigo_seq OWNED BY public.pagamento_ordem.pag_ord_codigo;

CREATE INDEX ix_fk_forma_pagamento_pagamento
 ON public.pagamento_ordem USING BTREE
 ( for_pag_codigo );

CREATE INDEX ix_fk_ordem_pagamento_ordem
 ON public.pagamento_ordem USING BTREE
 ( ord_codigo );

CREATE INDEX ix_fk_usuario_pagamento_ordem
 ON public.pagamento_ordem USING BTREE
 ( usu_codigo );

CREATE SEQUENCE public.ordem_produto_ord_pro_codigo_seq;

CREATE TABLE public.ordem_produto (
                ord_pro_codigo INTEGER NOT NULL DEFAULT nextval('public.ordem_produto_ord_pro_codigo_seq'),
                ord_codigo INTEGER NOT NULL,
                pro_codigo INTEGER NOT NULL,
                usu_codigo INTEGER NOT NULL,
                ord_pro_quantidade NUMERIC(10,3) NOT NULL,
                ord_pro_valor_unitario NUMERIC(10,2) NOT NULL,
                ord_pro_valor_total NUMERIC(10,2) NOT NULL,
                ord_pro_peso_unitario NUMERIC(10,3),
                ord_pro_peso_total NUMERIC(10,3),
                CONSTRAINT pk_ordem_produto PRIMARY KEY (ord_pro_codigo)
);


ALTER SEQUENCE public.ordem_produto_ord_pro_codigo_seq OWNED BY public.ordem_produto.ord_pro_codigo;

CREATE INDEX ix_fk_ordem_ordem_produto
 ON public.ordem_produto USING BTREE
 ( ord_codigo );

CREATE INDEX ix_fk_produto_ordem_produto
 ON public.ordem_produto USING BTREE
 ( pro_codigo );

CREATE INDEX ix_fk_usuario_ordem_produto
 ON public.ordem_produto USING BTREE
 ( usu_codigo );

CREATE SEQUENCE public.conta_con_codigo_seq;

CREATE TABLE public.conta (
                con_codigo INTEGER NOT NULL DEFAULT nextval('public.conta_con_codigo_seq'),
                pes_codigo INTEGER NOT NULL,
                con_numero_conta VARCHAR(20) NOT NULL,
                con_agencia VARCHAR(20) NOT NULL,
                con_operacao VARCHAR(20) NOT NULL,
                con_numero_banco INTEGER,
                con_nome_deposito VARCHAR(40) NOT NULL,
                ban_codigo INTEGER NOT NULL,
                CONSTRAINT pk_conta PRIMARY KEY (con_codigo)
);


ALTER SEQUENCE public.conta_con_codigo_seq OWNED BY public.conta.con_codigo;

CREATE INDEX ix_fk_pessoa_conta
 ON public.conta USING BTREE
 ( pes_codigo );

CREATE SEQUENCE public.veiculo_vei_codigo_seq;

CREATE TABLE public.veiculo (
                vei_codigo INTEGER NOT NULL DEFAULT nextval('public.veiculo_vei_codigo_seq'),
                vei_placa CHAR(8) NOT NULL,
                vei_veiculo VARCHAR(50) NOT NULL,
                cid_codigo INTEGER NOT NULL,
                pes_cat_codigo INTEGER NOT NULL,
                CONSTRAINT pk_veiculo PRIMARY KEY (vei_codigo)
);


ALTER SEQUENCE public.veiculo_vei_codigo_seq OWNED BY public.veiculo.vei_codigo;

CREATE INDEX ix_fk_cidade_veiculo
 ON public.veiculo USING BTREE
 ( cid_codigo );

CREATE SEQUENCE public.categoria_despesa_cat_des_codigo_seq;

CREATE TABLE public.categoria_despesa (
                cat_des_codigo INTEGER NOT NULL DEFAULT nextval('public.categoria_despesa_cat_des_codigo_seq'),
                cat_des_descricao VARCHAR(40) NOT NULL,
                CONSTRAINT pk_categoria_despesa PRIMARY KEY (cat_des_codigo)
);


ALTER SEQUENCE public.categoria_despesa_cat_des_codigo_seq OWNED BY public.categoria_despesa.cat_des_codigo;

CREATE SEQUENCE public.despesa_des_codigo_seq;

CREATE TABLE public.despesa (
                des_codigo INTEGER NOT NULL DEFAULT nextval('public.despesa_des_codigo_seq'),
                cat_des_codigo INTEGER NOT NULL,
                usu_codigo INTEGER NOT NULL,
                des_valor NUMERIC(10,2) NOT NULL,
                des_data DATE NOT NULL,
                des_descricao VARCHAR(100),
                CONSTRAINT pk_despesa PRIMARY KEY (des_codigo)
);


ALTER SEQUENCE public.despesa_des_codigo_seq OWNED BY public.despesa.des_codigo;

CREATE INDEX ix_fk_categoria_despesa_despesa
 ON public.despesa USING BTREE
 ( cat_des_codigo );

CREATE INDEX ix_fk_usuario_despesa
 ON public.despesa USING BTREE
 ( usu_codigo );

CREATE SEQUENCE public.venda_ven_codigo_seq;

CREATE TABLE public.venda (
                ven_codigo INTEGER NOT NULL DEFAULT nextval('public.venda_ven_codigo_seq'),
                vei_codigo INTEGER NOT NULL,
                usu_codigo INTEGER NOT NULL,
                ven_data DATE NOT NULL,
                ven_data_entrega DATE NOT NULL,
                ven_valor_total NUMERIC(10,2),
                ven_peso_total NUMERIC(10,3),
                ven_valor_frete NUMERIC(10,2),
                ven_icms NUMERIC(10,2) NOT NULL,
                ven_seguro NUMERIC(10,2),
                ven_valor_liquido NUMERIC(10,2),
                pes_cat_codigo INTEGER NOT NULL,
                ven_fechada VARCHAR(1),
                CONSTRAINT pk_venda PRIMARY KEY (ven_codigo)
);


ALTER SEQUENCE public.venda_ven_codigo_seq OWNED BY public.venda.ven_codigo;

CREATE INDEX ix_fk_pessoa_categoria_venda
 ON public.venda USING BTREE
 ( pes_cat_codigo );

CREATE INDEX ix_fk_usuario_venda
 ON public.venda USING BTREE
 ( usu_codigo );

CREATE INDEX ix_fk_veiculo_venda
 ON public.venda USING BTREE
 ( vei_codigo );

CREATE SEQUENCE public.produto_venda_pro_ven_codigo_seq;

CREATE TABLE public.produto_venda (
                pro_ven_codigo INTEGER NOT NULL DEFAULT nextval('public.produto_venda_pro_ven_codigo_seq'),
                pro_codigo INTEGER NOT NULL,
                usu_codigo INTEGER NOT NULL,
                ven_codigo INTEGER NOT NULL,
                pro_ven_quantidade NUMERIC(10,2) NOT NULL,
                pro_ven_peso_unitario NUMERIC(10,3) NOT NULL,
                pro_ven_peso_total NUMERIC(10,3) NOT NULL,
                pro_ven_valor_unitario NUMERIC(10,2),
                pro_ven_valor_total NUMERIC(10,2),
                pro_ven_nome_fornecedor VARCHAR(70),
                CONSTRAINT pk_produto_venda PRIMARY KEY (pro_ven_codigo)
);


ALTER SEQUENCE public.produto_venda_pro_ven_codigo_seq OWNED BY public.produto_venda.pro_ven_codigo;

CREATE INDEX ix_fk_produto_produto_venda
 ON public.produto_venda USING BTREE
 ( pro_codigo );

CREATE INDEX ix_fk_usuario_produto_venda
 ON public.produto_venda USING BTREE
 ( usu_codigo );

CREATE INDEX ix_fk_venda_produto_venda
 ON public.produto_venda USING BTREE
 ( ven_codigo );

CREATE SEQUENCE public.telefone_tel_codigo_seq;

CREATE TABLE public.telefone (
                tel_codigo INTEGER NOT NULL DEFAULT nextval('public.telefone_tel_codigo_seq'),
                pes_codigo INTEGER NOT NULL,
                tip_codigo INTEGER NOT NULL,
                tel_numero VARCHAR(20) NOT NULL,
                tel_contato VARCHAR(40),
                CONSTRAINT pk_telefone PRIMARY KEY (tel_codigo)
);


ALTER SEQUENCE public.telefone_tel_codigo_seq OWNED BY public.telefone.tel_codigo;

CREATE INDEX ix_fk_pessoa_telefone
 ON public.telefone USING BTREE
 ( pes_codigo );

CREATE INDEX ix_fk_tipo_telefone
 ON public.telefone USING BTREE
 ( tip_codigo );

CREATE SEQUENCE public.acesso_ace_codigo_seq;

CREATE TABLE public.acesso (
                ace_codigo INTEGER NOT NULL DEFAULT nextval('public.acesso_ace_codigo_seq'),
                ace_descricao VARCHAR(30) NOT NULL,
                CONSTRAINT pk_acesso PRIMARY KEY (ace_codigo)
);


ALTER SEQUENCE public.acesso_ace_codigo_seq OWNED BY public.acesso.ace_codigo;

CREATE SEQUENCE public.acesso_usuario_ace_usu_codigo_seq;

CREATE TABLE public.acesso_usuario (
                ace_usu_codigo INTEGER NOT NULL DEFAULT nextval('public.acesso_usuario_ace_usu_codigo_seq'),
                ace_codigo INTEGER NOT NULL,
                usu_codigo INTEGER NOT NULL,
                CONSTRAINT pk_acesso_usuario PRIMARY KEY (ace_usu_codigo)
);


ALTER SEQUENCE public.acesso_usuario_ace_usu_codigo_seq OWNED BY public.acesso_usuario.ace_usu_codigo;

CREATE INDEX ix_fk_acesso_usuario
 ON public.acesso_usuario USING BTREE
 ( ace_codigo );

CREATE INDEX ix_fk_usuario_acesso
 ON public.acesso_usuario USING BTREE
 ( usu_codigo );

CREATE SEQUENCE public.acao_aca_codigo_seq;

CREATE TABLE public.acao (
                aca_codigo INTEGER NOT NULL DEFAULT nextval('public.acao_aca_codigo_seq'),
                aca_descricao VARCHAR(20) NOT NULL,
                CONSTRAINT pk_acao PRIMARY KEY (aca_codigo)
);


ALTER SEQUENCE public.acao_aca_codigo_seq OWNED BY public.acao.aca_codigo;

ALTER TABLE public.pessoa_categoria ADD CONSTRAINT categoria_pessoa_categoria_fk
FOREIGN KEY (CAT_CODIGO)
REFERENCES public.CATEGORIA (CAT_CODIGO)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pagamento_ordem ADD CONSTRAINT fk_forma_pagamento_pagamento
FOREIGN KEY (for_pag_codigo)
REFERENCES public.forma_pagamento (for_pag_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.produto ADD CONSTRAINT fk_unidade_medida_produto
FOREIGN KEY (uni_med_codigo)
REFERENCES public.unidade_medida (uni_med_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.produto_venda ADD CONSTRAINT fk_produto_produto_venda
FOREIGN KEY (pro_codigo)
REFERENCES public.produto (pro_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.ordem_produto ADD CONSTRAINT fk_produto_ordem_produto
FOREIGN KEY (pro_codigo)
REFERENCES public.produto (pro_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.quebra ADD CONSTRAINT fk_produto_quebra
FOREIGN KEY (pro_codigo)
REFERENCES public.produto (pro_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.acesso_usuario ADD CONSTRAINT fk_usuario_acesso
FOREIGN KEY (usu_codigo)
REFERENCES public.usuario (usu_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.venda ADD CONSTRAINT fk_usuario_venda
FOREIGN KEY (usu_codigo)
REFERENCES public.usuario (usu_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.pessoa ADD CONSTRAINT fk_usuario_pessoa
FOREIGN KEY (usu_codigo)
REFERENCES public.usuario (usu_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.ordem ADD CONSTRAINT fk_usuario_ordem
FOREIGN KEY (usu_codigo)
REFERENCES public.usuario (usu_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.caixa ADD CONSTRAINT usuario_caixa_fk
FOREIGN KEY (usu_codigo)
REFERENCES public.usuario (usu_codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.produto_venda ADD CONSTRAINT fk_usuario_produto_venda
FOREIGN KEY (usu_codigo)
REFERENCES public.usuario (usu_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.ordem_produto ADD CONSTRAINT fk_usuario_ordem_produto
FOREIGN KEY (usu_codigo)
REFERENCES public.usuario (usu_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.pagamento_ordem ADD CONSTRAINT fk_usuario_pagamento_ordem
FOREIGN KEY (usu_codigo)
REFERENCES public.usuario (usu_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.despesa ADD CONSTRAINT fk_usuario_despesa
FOREIGN KEY (usu_codigo)
REFERENCES public.usuario (usu_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.quebra ADD CONSTRAINT fk_usuario_quebra
FOREIGN KEY (usu_codigo)
REFERENCES public.usuario (usu_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.pagamento_funcionario ADD CONSTRAINT fk_usuario_pagamento_funcionario
FOREIGN KEY (usu_codigo)
REFERENCES public.usuario (usu_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.conta ADD CONSTRAINT banco_conta_fk
FOREIGN KEY (ban_codigo)
REFERENCES public.banco (ban_codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.veiculo ADD CONSTRAINT fk_cidade_veiculo
FOREIGN KEY (cid_codigo)
REFERENCES public.cidade (cid_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.pessoa ADD CONSTRAINT fk_cidade_pessoa
FOREIGN KEY (cid_codigo)
REFERENCES public.cidade (cid_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.telefone ADD CONSTRAINT fk_tipo_telefone
FOREIGN KEY (tip_codigo)
REFERENCES public.tipo_telefone (tip_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.telefone ADD CONSTRAINT fk_pessoa_telefone
FOREIGN KEY (pes_codigo)
REFERENCES public.pessoa (pes_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.conta ADD CONSTRAINT fk_pessoa_conta
FOREIGN KEY (pes_codigo)
REFERENCES public.pessoa (pes_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.pessoa_categoria ADD CONSTRAINT fk_pessoa_pessoa_categoria
FOREIGN KEY (pes_codigo)
REFERENCES public.pessoa (pes_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.venda ADD CONSTRAINT fk_pessoa_categoria_venda
FOREIGN KEY (pes_cat_codigo)
REFERENCES public.pessoa_categoria (pes_cat_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.veiculo ADD CONSTRAINT pessoa_categoria_veiculo_fk
FOREIGN KEY (pes_cat_codigo)
REFERENCES public.pessoa_categoria (pes_cat_codigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.ordem ADD CONSTRAINT fk_pessoa_categoria_ordem
FOREIGN KEY (pes_cat_codigo)
REFERENCES public.pessoa_categoria (pes_cat_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.horas_trabalhadas ADD CONSTRAINT fk_pessoa_categoria_horas_trabalhadas
FOREIGN KEY (pes_cat_codigo)
REFERENCES public.pessoa_categoria (pes_cat_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.pagamento_funcionario ADD CONSTRAINT fk_pessoa_categoria_pagamento_funcionario
FOREIGN KEY (pes_cat_codigo)
REFERENCES public.pessoa_categoria (pes_cat_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.ordem_produto ADD CONSTRAINT fk_ordem_ordem_produto
FOREIGN KEY (ord_codigo)
REFERENCES public.ordem (ord_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.pagamento_ordem ADD CONSTRAINT fk_ordem_pagamento_ordem
FOREIGN KEY (ord_codigo)
REFERENCES public.ordem (ord_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.venda ADD CONSTRAINT fk_veiculo_venda
FOREIGN KEY (vei_codigo)
REFERENCES public.veiculo (vei_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.despesa ADD CONSTRAINT fk_categoria_despesa_despesa
FOREIGN KEY (cat_des_codigo)
REFERENCES public.categoria_despesa (cat_des_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.produto_venda ADD CONSTRAINT fk_venda_produto_venda
FOREIGN KEY (ven_codigo)
REFERENCES public.venda (ven_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.acesso_usuario ADD CONSTRAINT fk_acesso_usuario
FOREIGN KEY (ace_codigo)
REFERENCES public.acesso (ace_codigo)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;



insert into categoria(cat_codigo,cat_descricao)values(1,'Funcionário');
insert into categoria(cat_codigo,cat_descricao)values(2,'Cliente');
insert into categoria(cat_codigo,cat_descricao)values(3,'Forneccedor');
insert into categoria(cat_codigo,cat_descricao)values(4,'Transportadora');
