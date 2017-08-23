------------------------------------------------------------------------------
-- Table: public.contatos

-- DROP TABLE public.contatos;

CREATE TABLE public.contatos
(
    nome character(255) COLLATE pg_catalog."default",
    id integer NOT NULL DEFAULT nextval('contatos_id_seq'::regclass),
    endereco character(255) COLLATE pg_catalog."default",
    email character(255) COLLATE pg_catalog."default",
    data_nascimento date,
    CONSTRAINT contatos_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.contatos
    OWNER to postgres;
    
------------------------------------------------------------------------------    