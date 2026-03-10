package com.marvellous.MarvellousFullstackX.Controller;

import jakarta.validation.Valid;
import com.marvellous.MarvellousFullstackX.Entity.BatchEntry;
import com.marvellous.MarvellousFullstackX.Service.BatchEntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/batches")
public class BatchEntryController
{
    @Autowired
    private BatchEntryService batchEntryService;

    // GET ALL
    @GetMapping
    public ResponseEntity<?> getAll()
    {
        List<BatchEntry> alldata = batchEntryService.getAll();

        if(!alldata.isEmpty())
        {
            return new ResponseEntity<>(alldata , HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // CREATE
    @PostMapping
    public ResponseEntity<BatchEntry> createEntry(@Valid @RequestBody BatchEntry myentry)
    {
        BatchEntry savedEntry = batchEntryService.saveEntry(myentry);
        return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
    }

    // UPDATE
    @PutMapping("/id/{myid}")
    public ResponseEntity<?> updateEntry(@PathVariable String myid,
                                         @Valid @RequestBody BatchEntry updatedEntry)
    {
        Optional<BatchEntry> entry = batchEntryService.updateEntry(myid, updatedEntry);

        if(entry.isPresent())
        {
            return new ResponseEntity<>(entry.get(), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/id/{myid}")
    public ResponseEntity<?> deleteEntry(@PathVariable String myid)
    {
        boolean deleted = batchEntryService.deleteById(myid);

        if(deleted)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}