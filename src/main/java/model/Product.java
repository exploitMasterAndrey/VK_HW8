package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.r2dbc.spi.Parameter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
public class Product { //TODO: добивить аннотации Jackson для сериализации/десериализации
    @JsonProperty("id")
    private @NotNull Integer id;

    @JsonProperty("name")
    private @NotNull String name;

    @JsonProperty("factoryName")
    private @NotNull String factoryName;

    @JsonProperty("count")
    private @NotNull Integer count;

    @JsonCreator
    public Product(@JsonProperty(value = "name", required = true) String name, @JsonProperty(value = "factoryName", required = true) String factoryName, @JsonProperty(value = "count", required = true) Integer count){
        this.id = 0;
        this.name = name;
        this.factoryName = factoryName;
        this.count = count;
    }
}
