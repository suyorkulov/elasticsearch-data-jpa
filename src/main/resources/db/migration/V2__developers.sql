CREATE TABLE developers (
  id           BIGSERIAL PRIMARY KEY,
  created_date TIMESTAMP    NOT NULL,
  first_name   VARCHAR(255) NOT NULL,
  last_name    VARCHAR(255) NOT NULL,
  position     VARCHAR(255) NOT NULL
);

CREATE TABLE skills (
  id           BIGSERIAL PRIMARY KEY,
  created_date TIMESTAMP    NOT NULL,
  name         VARCHAR(255) NOT NULL
);

CREATE TABLE developers_skills (
  developer_id BIGINT REFERENCES developers (id),
  skill_id     BIGINT REFERENCES skills (id)
);