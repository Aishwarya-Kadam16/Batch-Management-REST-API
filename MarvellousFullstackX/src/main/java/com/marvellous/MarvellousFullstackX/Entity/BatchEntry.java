package com.marvellous.MarvellousFullstackX.Entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

@Getter
@Setter
@Document (collection = "BatchDetails")
public class BatchEntry
{
    @Id
    private String id;

    @NotBlank(message = "Batch name cannot be empty")
    private String name;

    @Min(value = 0, message = "Fees must be positive")
    private int fees;

}
