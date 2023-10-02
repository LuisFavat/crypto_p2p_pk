package ar.model.factory;

import java.time.LocalDateTime;

public class TimeFactory
{
    public static LocalDateTime anyTime()
    {
        return LocalDateTime.now();
    }
}
