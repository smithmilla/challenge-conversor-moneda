package main.java.models;

public record ExchangeRate(String result,
                           String base_code,
                           String target_code,
                           Double conversion_rate,
                           Double conversion_result)
{
}
