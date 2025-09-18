
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

# Fix schema collation issue
REINDEX database postgres;
ALTER DATABASE postgres REFRESH COLLATION VERSION;
```

## Redis
```
# Install Redis using Docker
docker pull redis

# Exposed on port 6369 to avoid conflicts with local installations
docker run --name local-redis -d -p 6379:6379 redis

# Stop and remove:
docker stop local-redis
docker rm local-redis
```