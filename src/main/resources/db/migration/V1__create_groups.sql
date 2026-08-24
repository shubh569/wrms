CREATE TABLE groups (
                        id UUID PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);