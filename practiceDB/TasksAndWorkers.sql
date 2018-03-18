create table Worker
(WorkerID int PRIMARY KEY IDENTITY(1, 1), 
Name varchar(30) NOT NULL, 
Position varchar(30), 
Phone varchar(30),
Salary int);

create table Task
(TaskID int PRIMARY KEY IDENTITY(1, 1), 
Specification varchar(30) NOT NULL, 
Task_priority int, 
Difficulty int);

create table TasksAndWorkers
(TaskID int,
WorkerID int, 
PRIMARY KEY(TaskID, WorkerID));

ALTER TABLE TasksAndWorkers    
ADD CONSTRAINT FK_Task FOREIGN KEY (TaskID)     
    REFERENCES Task (TaskID)     
    ON DELETE CASCADE  

ALTER TABLE TasksAndWorkers    
ADD CONSTRAINT FK_Worker FOREIGN KEY (WorkerID)     
    REFERENCES Worker (WorkerID)     
    ON DELETE CASCADE  


INSERT INTO Worker VALUES
('Ivan', 'Dev', '88005553535', 35000);

INSERT INTO Worker VALUES
('Feofan', 'Junior Dev', '89263331895', 20000);

select * from Worker

INSERT INTO Task VALUES
('Geom', 5, 3);

INSERT INTO Task VALUES
('DB design', 4, 7);

INSERT INTO Task VALUES
('Machine Learning', 2, 8);

select * from Task

INSERT INTO TasksAndWorkers VALUES
(1, 1);

INSERT INTO TasksAndWorkers VALUES
(1, 2);

INSERT INTO TasksAndWorkers VALUES
(2, 1);

INSERT INTO TasksAndWorkers VALUES
(2, 2);

INSERT INTO TasksAndWorkers VALUES
(3, 2);

select * from TasksAndWorkers 