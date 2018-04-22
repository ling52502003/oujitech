-- Table: testdb."user"

-- DROP TABLE testdb."user";

CREATE TABLE testdb."user"
(
    id "char" NOT NULL,
    name "char",
    CONSTRAINT pk_user PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE testdb."user"
    OWNER to postgres;