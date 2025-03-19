-- Add a unique constraint to the email column in the student table
ALTER TABLE student ADD CONSTRAINT email_unique UNIQUE (email);

-- Add an index to the name column in the student table
CREATE INDEX idx_student_name ON student (name);

-- Add a unique constraint to the unique_student_code column in the student table
ALTER TABLE student ADD CONSTRAINT unique_student_code_unique UNIQUE (unique_student_code);