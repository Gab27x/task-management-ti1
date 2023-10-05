package model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends TypeAdapter<LocalDate> {

    @Override
    public void write(JsonWriter out, LocalDate value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
    }

    @Override
    public LocalDate read(JsonReader in) throws IOException {
        if (in.peek() == null) {
            in.nextNull();
            return null;
        }
        String dateString = in.nextString();
        return LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
    }
}