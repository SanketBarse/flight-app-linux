package com.flight.app.model;

public record FlightAppRegistrationData(String firstName,
                                        String lastName,
                                        String email,
                                        String password,
                                        String street,
                                        String city,
                                        String state,
                                        String zip) {
}
