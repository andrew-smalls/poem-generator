
# Poem Generator Backend

## Postgres

User: postgres
Password: postgres

```
SET search_path TO postgres,"poem-generator";

drop table if exists "poem-generator".poem;

CREATE TABLE IF NOT EXISTS "poem-generator".poem
(
    id serial PRIMARY KEY,
    user_id uuid NOT NULL,
    theme varchar(100),
    content text,
    creation_date time without time zone
)

Insert into poem (user_id, theme, content, creation_date) values 
('292a485f-a56a-4938-8f1a-bbbbbbbbbbb1', 'love', 'Some love poem', now()),
('292a485f-a56a-4938-8f1a-bbbbbbbbbbb2', 'hate', 'Some hate poem', now()),
('292a485f-a56a-4938-8f1a-bbbbbbbbbbb3', 'sadness', 'Some sadness poem', now());
```

