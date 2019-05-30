package alessandro.mystudio.ticketfirebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import alessandro.mystudio.ticketfirebase.RecyclerView.Ticket;

public class RecyclerView_Config {

    private Context mContext;
    private TicketAdapter mTicketAdapter;
    public void setConfig(RecyclerView recyclerView,Context context,List<Ticket> tickets,List<String> keys){
        mContext = context;
        mTicketAdapter = new TicketAdapter(tickets,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mTicketAdapter);

    }


    class TicketItemView  extends RecyclerView.ViewHolder {

        private TextView mTicket;
        private TextView mRedattore;
        private TextView mTarga;
        private TextView mdataApertura;
        private TextView mMaterialeG;
        private TextView mdataChiusura;

        private String key;//in caso da cancellare

        public TicketItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.example_item_recyclerview,parent,false));

            mTicket = (TextView)itemView.findViewById(R.id.txt_ticket);
            mRedattore = (TextView)itemView.findViewById(R.id.txt_redattore);
            mTarga = (TextView)itemView.findViewById(R.id.txt_targa);
            mdataApertura = (TextView)itemView.findViewById(R.id.txt_dataA);
            mMaterialeG = (TextView)itemView.findViewById(R.id.txt_materiale);
            mdataChiusura = (TextView)itemView.findViewById(R.id.txt_dataC);

        }
        public void bind(Ticket ticket,String key){
            mTicket.setText(ticket.getTicket());
            mRedattore.setText(ticket.getRedattore());
            mTarga.setText(ticket.getTarga());
            mdataApertura.setText(ticket.getDataApertura());
            mMaterialeG.setText(ticket.getMaterialeGuasto());
            mdataChiusura.setText(ticket.getDataChiusura());
            this.key = key;//in caso da cancellare
        }
    }
    class TicketAdapter extends RecyclerView.Adapter<TicketItemView>{
        private List<Ticket> mTicketList;//in caso sostituire con ArrayList<Ticket>
        private List<String> mKeys;//in caso da cancellare

        public TicketAdapter(List<Ticket> mTicketList, List<String> mKeys) {
            this.mTicketList = mTicketList;
            this.mKeys = mKeys;
        }


        @Override
        public TicketItemView onCreateViewHolder( ViewGroup parent, int i) {
            return new TicketItemView(parent);
        }

        @Override
        public void onBindViewHolder(TicketItemView holder, int position) {
            holder.bind(mTicketList.get(position),mKeys.get(position));

        }

        @Override
        public int getItemCount() {
            return mTicketList.size();
        }
    }
}
