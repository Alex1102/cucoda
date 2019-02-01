CREATE SCHEMA carlos;

CREATE SEQUENCE carlos.contract_id_seq;

CREATE TABLE carlos.acf_types
(
  id SERIAL PRIMARY KEY ,
  acf_type VARCHAR NOT NULL
);


CREATE TABLE carlos.acf
(
--   acf_id BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('contract_id_seq'),
  acf_id SERIAL PRIMARY KEY ,
  interim_account_id VARCHAR NOT NULL,
  account_id VARCHAR,
  acf_type_id INTEGER NOT NULL,
  order_id VARCHAR NOT NULL,
  provisioning_id VARCHAR NOT NULL,
  created_at TIMESTAMP NOT NULL,
  deleted_at TIMESTAMP,
  FOREIGN KEY (acf_type_id) REFERENCES carlos.acf_types (id)
);


CREATE UNIQUE INDEX carlos_acf_types_unique_typex on carlos.acf_types (acf_type);
CREATE UNIQUE INDEX carlos_acfs_unique_provisioningIdx on carlos.acf (provisioning_id);
CREATE UNIQUE INDEX carlos_acfs_unique_accountIdAndacfTypeIdx on carlos.acf (interim_account_id, acf_type_id);
