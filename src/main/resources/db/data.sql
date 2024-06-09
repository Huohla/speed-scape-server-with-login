-- Insert users
INSERT INTO game_user (id, username, email, password, points, role)
VALUES
    ('550e8400-e29b-41d4-a716-446655440002', 'admin', 'correo@correo.es', '1234', 100000, 'USER'),
    ('550e8400-e29b-41d4-a716-446655440000', 'john_doe', 'john@example.com', 'password123', 0, 'USER'),
    ('550e8400-e29b-41d4-a716-446655440001', 'jane_doe', 'jane@example.com', 'password123', 11230123, 'ADMIN')
ON CONFLICT DO NOTHING;

-- Insert categories
INSERT INTO category (id, name)
VALUES ('650e8400-e29b-41d4-a716-446655440000', 'Technology')
ON CONFLICT DO NOTHING;

-- Insert sub-categories
INSERT INTO sub_category (id, name, parent_id)
VALUES ('650e8400-e29b-41d4-a716-446655440000', 'Electronics', '650e8400-e29b-41d4-a716-446655440000'),
       ('650e8400-e29b-41d4-a716-446655440001', 'Smartphones', '650e8400-e29b-41d4-a716-446655440000'),
       ('650e8400-e29b-41d4-a716-446655440002', 'Laptops', '650e8400-e29b-41d4-a716-446655440000')
ON CONFLICT DO NOTHING;

-- Insert products
INSERT INTO product (id, name, price, description, image, sub_category)
VALUES ('750e8400-e29b-41d4-a716-446655440000', 'iPhone 12', 799, 'Latest Apple smartphone',
        '850e8400-e29b-41d4-a716-446655440000', '650e8400-e29b-41d4-a716-446655440001'),
       ('750e8400-e29b-41d4-a716-446655440001', 'MacBook Pro', 1299, 'Latest Apple laptop',
        '850e8400-e29b-41d4-a716-446655440001', '650e8400-e29b-41d4-a716-446655440002')
ON CONFLICT DO NOTHING;

-- Insert transactions
INSERT INTO transaction (id, user_id, type)
VALUES ('850e8400-e29b-41d4-a716-446655440000', '550e8400-e29b-41d4-a716-446655440000', 'PURCHASE'),
       ('850e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440001', 'PURCHASE')
ON CONFLICT DO NOTHING;

-- Insert product transactions references
INSERT INTO product_transaction_ref (id, product_id, transaction_id)
VALUES ('950e8400-e29b-41d4-a716-446655440000', '750e8400-e29b-41d4-a716-446655440000',
        '850e8400-e29b-41d4-a716-446655440000'),
       ('950e8400-e29b-41d4-a716-446655440001', '750e8400-e29b-41d4-a716-446655440001',
        '850e8400-e29b-41d4-a716-446655440001')
ON CONFLICT DO NOTHING;
