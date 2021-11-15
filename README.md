#User Resource 
    # Spring Boot + Postgres + lombok 


#Goals project
- In this project It'ed implement using Hexagonal

#Data Base
- In this project we'll use Postegres

#Hexagonal Architecture
    - Hexagonal architecture is a model of designing software applications around domain 
      logic to isolate it from external factors. The domain logic is specified in a business core,
      which we'll call the inside part, the rest being outside parts. Access to domain logic from 
      the outside is available through ports and adapters.

#Organize packages

    -com.itau.user-resource
        -infra
            -mapper
            -util
            -config
        -adapter
            -dataprovider
            -controller
        -usecase
        -entity
            
         
              