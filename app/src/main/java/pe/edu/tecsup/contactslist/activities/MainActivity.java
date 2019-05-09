package pe.edu.tecsup.contactslist.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import pe.edu.tecsup.contactslist.R;
import pe.edu.tecsup.contactslist.adapters.ContactAdapter;
import pe.edu.tecsup.contactslist.models.Contact;
import pe.edu.tecsup.contactslist.repositories.ContactRepository;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.contactlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ContactAdapter adapter = new ContactAdapter(this);

        List<Contact> contacts = ContactRepository.getContacts();
        adapter.setContacts(contacts);

        recyclerView.setAdapter(adapter);
    }
}
