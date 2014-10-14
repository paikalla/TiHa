CREATE TABLE kayttaja (
  id SERIAL PRIMARY KEY,
  kayttajatunnus text NOT NULL,
  salasana text NOT NULL
);

CREATE TABLE askare (
  id SERIAL PRIMARY KEY,
  kuvaus text NOT NULL,
  tarkeys integer,
  kayttaja_id integer REFERENCES kayttaja (id) ON DELETE cascade,
  luokka_id integer REFERENCES luokka(id) ON DELETE cascade
);

CREATE TABLE luokka (
  id SERIAL PRIMARY KEY,
  nimi text NOT NULL
);
