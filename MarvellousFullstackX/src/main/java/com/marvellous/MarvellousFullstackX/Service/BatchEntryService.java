package com.marvellous.MarvellousFullstackX.Service;

import com.marvellous.MarvellousFullstackX.Entity.BatchEntry;
import com.marvellous.MarvellousFullstackX.Repository.BatchEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchEntryService {

    @Autowired
    private BatchEntryRepository batchEntryRepository;

    // CREATE
    public BatchEntry saveEntry(BatchEntry batchEntry) {
        return batchEntryRepository.save(batchEntry);
    }

    // READ ALL
    public List<BatchEntry> getAll() {
        return batchEntryRepository.findAll();
    }

    // READ BY ID
    public Optional<BatchEntry> findById(String id) {
        return batchEntryRepository.findById(id);
    }

    // UPDATE
    public Optional<BatchEntry> updateEntry(String id, BatchEntry newEntry) {

        Optional<BatchEntry> existingEntry = batchEntryRepository.findById(id);

        if (existingEntry.isPresent()) {
            BatchEntry entry = existingEntry.get();

            entry.setName(newEntry.getName());
            entry.setFees(newEntry.getFees());

            return Optional.of(batchEntryRepository.save(entry));
        }

        return Optional.empty();
    }

    // DELETE
    public boolean deleteById(String id) {

        if (batchEntryRepository.existsById(id)) {
            batchEntryRepository.deleteById(id);
            return true;
        }

        return false;
    }
}