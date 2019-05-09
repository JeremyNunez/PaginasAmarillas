package pe.edu.tecsup.contactslist.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.contactslist.R;
import pe.edu.tecsup.contactslist.activities.DetailContactActivity;
import pe.edu.tecsup.contactslist.models.Contact;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private static final String TAG = ContactAdapter.class.getSimpleName();

    private AppCompatActivity activity;

    private List<Contact> contacts;

    public ContactAdapter(AppCompatActivity activity){
        this.activity = activity;
        contacts = new ArrayList<>();
    }

    public void setContacts(List<Contact> contacts){
        this.contacts = contacts;
    }

    @NonNull
    @Override   // Qué layout va a usar y mantenerlo precargado
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contact, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override   // Cómo se va a enlazar el dato en cada item layout (ViewHolder)
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Contact contact = this.contacts.get(position);

        viewHolder.fullnameText.setText(contact.getFullname());
        viewHolder.emailText.setText(contact.getEmail());

        Context context = viewHolder.itemView.getContext();
        int resourceid = context.getResources().getIdentifier(
                contact.getPicture(),
                "drawable",
                context.getPackageName()
        );
        viewHolder.pictureImage.setImageResource(resourceid);

        // Definiendo el evento onclick
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + contact);

                Intent intent = new Intent(v.getContext(), DetailContactActivity.class);
                intent.putExtra("id", contact.getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView pictureImage;
        TextView fullnameText;
        TextView emailText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pictureImage = itemView.findViewById(R.id.picture_image);
            fullnameText = itemView.findViewById(R.id.fullname_text);
            emailText = itemView.findViewById(R.id.email_text);
        }
    }

}
