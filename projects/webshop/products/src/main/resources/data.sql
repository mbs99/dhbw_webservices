insert into products (id,title,description,article_id) VALUES (0,'Flux Compensator', 'gelb, schwer', '1') ON CONFLICT ON CONSTRAINT products_pkey DO NOTHING;
insert into products (id,title,description,article_id) VALUES (1,'Warpkern', 'refurbished', '2') ON CONFLICT ON CONSTRAINT products_pkey DO NOTHING;