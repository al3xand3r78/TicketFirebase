package alessandro.mystudio.ticketfirebase;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceTicket;
    private List<alessandro.mystudio.ticketfirebase.RecyclerView.Ticket> Ticket = new ArrayList<>();
    public interface  DataStatus {
        void  DataIsLoaded(List<alessandro.mystudio.ticketfirebase.RecyclerView.Ticket> Ticket, List<String> Keys);
        void  DataIsInsereted();
        void  DataIsUpdated();
        void  DataIsDeleted();
    }

    public FirebaseDatabaseHelper(){
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceTicket = mDatabase.getReference("Ticket");

    }
    public void readTicket(final DataStatus dataStatus){
        mReferenceTicket.addValueEventListener(new ValueEventListener() {
            //TODO INSERIMENTO DEI DATI
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Ticket.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    alessandro.mystudio.ticketfirebase.RecyclerView.Ticket ticket = keyNode.getValue(alessandro.mystudio.ticketfirebase.RecyclerView.Ticket.class);
                    Ticket.add(ticket);
                }
                dataStatus.DataIsLoaded(Ticket, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
