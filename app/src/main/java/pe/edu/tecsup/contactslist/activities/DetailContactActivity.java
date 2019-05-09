package pe.edu.tecsup.contactslist.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.tecsup.contactslist.R;
import pe.edu.tecsup.contactslist.models.Contact;
import pe.edu.tecsup.contactslist.repositories.ContactRepository;

public class DetailContactActivity extends AppCompatActivity {

    private Integer id;

    private ImageView pictureImage;
    private TextView fullnameText;
    private TextView emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);

        pictureImage = findViewById(R.id.picture_image);
        fullnameText = findViewById(R.id.fullname_text);
        emailText = findViewById(R.id.email_text);

        this.id = getIntent().getExtras().getInt("id");

        Contact contact = ContactRepository.getContactById(id);

        if(contact != null) {
            int resourceid = getResources().getIdentifier(
                    contact.getPicture(),
                    "drawable",
                    getPackageName()
            );
            pictureImage.setImageResource(resourceid);
            fullnameText.setText(contact.getFullname());
            emailText.setText(contact.getEmail());
        }
    }
}
