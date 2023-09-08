-- Inserta datos ficticios en la tabla "clients"
INSERT INTO clients (Name, last_name, phone_number, mail, address)
VALUES
  ('María', 'Gómez', '1234567890', 'maria@example.com', 'Calle Principal 1'),
  ('Juan', 'Rodríguez', '9876543210', 'juan@example.com', 'Avenida Central 2'),
  ('Sofía', 'López', '5551234567', 'sofia@example.com', 'Calle Peatonal 3');

-- Inserta datos ficticios en la tabla "pets"
INSERT INTO pets (name, species, breed, age, client_id)
VALUES
  ('Rex', 'Perro', 'Labrador', 3, 1),
  ('Mittens', 'Gato', 'Siamese', 2, 2),
  ('Buddy', 'Perro', 'Golden Retriever', 4, 1);

-- Inserta datos ficticios en la tabla "appointments"
INSERT INTO appointments (date, pet_id, client_id)
VALUES
  ('2023-09-01 09:00:00', 1, 1),
  ('2023-09-02 10:30:00', 2, 2),
  ('2023-09-03 15:15:00', 3, 1);

-- Inserta datos ficticios en la tabla "treatments"
INSERT INTO treatments (name, description, price, pet_id)
VALUES
  ('Vacunación', 'Vacuna anual', 50.0, 1),
  ('Desparasitación', 'Desparasitación mensual', 20.0, 2),
  ('Cirugía', 'Esterilización', 120.0, 3);

-- Inserta datos ficticios en la tabla "payments"
INSERT INTO payments (fecha, cantidad, client_id)
VALUES
  ('2023-09-01 14:30:00', 75.0, 1),
  ('2023-09-02 16:45:00', 35.0, 2),
  ('2023-09-03 11:00:00', 110.0, 1);

-- Inserta datos ficticios en la tabla "medical_histories"
INSERT INTO medical_histories (date, description, pet_id, treatment_id)
VALUES
  ('2023-09-02 10:00:00', 'Control de salud', 1, 1),
  ('2023-09-03 14:00:00', 'Chequeo de rutina', 2, 2),
  ('2023-09-04 11:30:00', 'Cirugía de esterilización', 3, 3);

-- Inserta datos ficticios en la tabla "users"
INSERT INTO users (name, lastname, mail, password)
VALUES
  ('Admin', 'Adminson', 'admin@example.com', 'admin123'),
  ('Usuario', 'Prueba', 'usuario@example.com', 'usuario456');

  -- Inserta datos ficticios en la tabla "pet_treatment"
  INSERT INTO pet_treatment (pet_id, treatment_id)
  VALUES
    (1, 1), -- Asigna el tratamiento 1 a la mascota 1
    (2, 2), -- Asigna el tratamiento 2 a la mascota 2
    (3, 3); -- Asigna el tratamiento 3 a la mascota 3;