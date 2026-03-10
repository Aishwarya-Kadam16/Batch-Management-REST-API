package com.marvellous.MarvellousFullstackX.Repository;

import com.marvellous.MarvellousFullstackX.Entity.BatchEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BatchEntryRepository extends MongoRepository<BatchEntry , String>
{

}
