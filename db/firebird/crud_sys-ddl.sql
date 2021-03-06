DECLARE EXTERNAL FUNCTION "LOWER"
   CSTRING(80)
   RETURNS CSTRING(80) FREE_IT
   ENTRY_POINT 'IB_UDF_lower' MODULE_NAME 'ib_udf';

CREATE GENERATOR GEN_PESSOA_ID;
SET GENERATOR GEN_PESSOA_ID TO 0;

CREATE TABLE PESSOA(
    ID_PESSOA BIGINT NOT NULL,
    CPF VARCHAR(11) NOT NULL,
    NASCIMENTO TIMESTAMP,
    NOME VARCHAR(45) NOT NULL
);

ALTER TABLE PESSOA ADD PRIMARY KEY (ID_PESSOA);


CREATE GENERATOR GEN_USUARIO_ID;
SET GENERATOR GEN_USUARIO_ID TO 0;

CREATE TABLE USUARIO(
    ID_USUARIO BIGINT NOT NULL,
    STATUS SMALLINT NOT NULL,
    LOGIN VARCHAR(30) NOT NULL,
    SENHA VARCHAR(80) NOT NULL,
    AUTORIZACOES VARCHAR(50),
    ID_PESSOA BIGINT NOT NULL
);

ALTER TABLE USUARIO ADD PRIMARY KEY (ID_USUARIO);
ALTER TABLE USUARIO ADD CONSTRAINT FK_USUARIO_PESSOA FOREIGN KEY (ID_PESSOA) REFERENCES PESSOA;


CREATE GENERATOR GEN_ENDERECO_ID;
SET GENERATOR GEN_ENDERECO_ID TO 0;

CREATE TABLE ENDERECO(
    ID_ENDERECO BIGINT NOT NULL,
    BAIRRO VARCHAR(50) NOT NULL,
    RUA VARCHAR(100) NOT NULL,
    TELEFONE VARCHAR(10) NOT NULL,
    ID_PESSOA BIGINT NOT NULL
);

ALTER TABLE ENDERECO ADD PRIMARY KEY (ID_ENDERECO);
ALTER TABLE ENDERECO ADD CONSTRAINT FK_ENDERECO_PESSOA FOREIGN KEY (ID_PESSOA) REFERENCES PESSOA;

--DROP GENERATOR GEN_MERCADORIA_ID;
CREATE GENERATOR GEN_MERCADORIA_ID;
SET GENERATOR GEN_MERCADORIA_ID TO 0;

--DROP TABLE MERCADORIA;
CREATE TABLE MERCADORIA(
    ID_MERCADORIA BIGINT NOT NULL,
	NOME VARCHAR(200) NOT NULL,
	QUANTIDADE INT NOT NULL,
    PRECO FLOAT NOT NULL       
);

ALTER TABLE MERCADORIA ADD PRIMARY KEY (ID_MERCADORIA);