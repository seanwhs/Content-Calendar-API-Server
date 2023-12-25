-- schema.sql

CREATE TABLE IF NOT EXISTS content (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    content_created TIMESTAMP NOT NULL,
    content_updated TIMESTAMP,
    url VARCHAR(255),
    -- Assuming tags should be stored as a comma-separated list
    tags VARCHAR(255)
);

-- data.sql

-- Inserting test data related to Spring Boot into the content table
INSERT INTO content (title, description, status, content_type, content_created, content_updated, url, tags)
VALUES
    ('Introduction to Spring Boot', 'A comprehensive guide to getting started with Spring Boot', 'IDEA', 'ARTICLE', '2023-01-10 09:00:00', NULL, 'http://example.com/spring-boot-intro', 'java,spring,boot'),
    ('Spring Boot Best Practices', 'Learn the best practices for developing applications with Spring Boot', 'IN_PROGRESS', 'VIDEO', '2023-02-20 14:30:00', '2023-02-25 11:15:00', 'http://example.com/spring-boot-best-practices', 'java,spring,development'),
    ('Spring Boot and Microservices', 'Exploring microservices architecture with Spring Boot', 'COMPLETED', 'COURSE', '2023-03-15 11:45:00', '2023-03-20 13:30:00', 'http://example.com/spring-boot-microservices', 'java,spring,microservices'),
    ('Advanced Spring Boot Features', 'In-depth look into advanced features of Spring Boot framework', 'IN_PROGRESS', 'CONFERENCE_TALK', '2023-04-05 08:00:00', NULL, 'http://example.com/spring-boot-advanced', 'java,spring,advanced'),
    ('Spring Boot Security Essentials', 'Securing your Spring Boot applications with best practices', 'DRAFT', 'GUIDE', '2023-05-02 10:30:00', '2023-05-05 09:45:00', 'http://example.com/spring-boot-security', 'java,spring,security');
