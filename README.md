All the assumptions made are:
- All the passengers are associated by a passengerId and a passengerName
- All the drivers are associated with a driverId and a driverName
- Every ride has unique RideId 

Approach to the solution and DB schema:
- Since passengers can rate the driver and driver can rate the passengers so I thought of storing both of them in a table with following records
    -   ride_id, passenger_id, driver_id, passenger_name, driver_name, passenger_rating, driver_rating, day, month, year
    -   here, ride_id would be used as a primary key
- Passenger can rate the driver and vice versa.
- It uses two post request mapping, one for driver to rate the passenger and the other for passenger to rate the driver.
- It also uses two get mappings, first, to calculate the aggregate of passenger ratings and second to calculate the aggregate of driver ratings.

    