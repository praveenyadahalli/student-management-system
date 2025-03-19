-- Create student table
CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(10) NOT NULL,
    unique_student_code VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100),
    mobile_number VARCHAR(15),
    parents_name VARCHAR(100)
);

-- Create student_address table
CREATE TABLE student_address (
    id SERIAL PRIMARY KEY,
    area VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    district VARCHAR(100) NOT NULL,
    pincode VARCHAR(10) NOT NULL,
    address_type VARCHAR(50) NOT NULL,
    student_id BIGINT REFERENCES student(id) ON DELETE CASCADE
);

-- Create course table
CREATE TABLE course (
    id SERIAL PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    description TEXT,
    course_type VARCHAR(50) NOT NULL,
    duration VARCHAR(50) NOT NULL
);

-- Create student_course join table
CREATE TABLE student_course (
    student_id BIGINT REFERENCES student(id) ON DELETE CASCADE,
    course_id BIGINT REFERENCES course(id) ON DELETE CASCADE,
    PRIMARY KEY (student_id, course_id)
);