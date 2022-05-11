# Backend (Spring Boot + Mybatis + Spring Security)

```plantuml

@startuml
!theme plain
top to bottom direction
skinparam linetype ortho

class user {
   username: varchar(20)
   password: varchar(100)
   name: text
   gender: integer
   is_admin: boolean
   birthday: timestamp(3)
   phone_num: varchar(15)
   home_address: text
   id: bigint
}
@enduml

```

## Spring Boot

### Controller

### Service


## Mybatis

### Mapper Interface

### Mapper SQL File

### Datasource Configuration

## Spring Security

### Security Purposes

### Flow of authentication

### Implementation
