package com.danilomaia.workshopspringbootmongodb.services.exceptions;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -8292884316850931196L;

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
