package alessandro.mystudio.ticketfirebase.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import alessandro.mystudio.ticketfirebase.R;

public  class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>{

    private ArrayList<Ticket>mExampleList;
    //Todo creazione lista da cercare



      public class ExampleViewHolder extends RecyclerView.ViewHolder{

         public TextView mTextticket;
         public TextView mTextredattore;
         public TextView mTexttarga;
         public TextView mTextdataA;
         public TextView mTextmanutenzioneG;
         public TextView mTextdataC;

        //todo creazione classe ViewHolder con salvataggio oggetti della riga
         public ExampleViewHolder(View itemView) {
            super(itemView);
            mTextticket = itemView.findViewById(R.id.txt_ticket);
            mTextredattore = itemView.findViewById(R.id.txt_redattore);
            mTexttarga = itemView.findViewById(R.id.txt_targa);
            mTextdataA = itemView.findViewById(R.id.txt_dataA);
            mTextmanutenzioneG = itemView.findViewById(R.id.txt_materiale);
            mTextdataC = itemView.findViewById(R.id.txt_dataC);

        }
    }

    public ExampleAdapter(ArrayList<Ticket> examplelist){
        mExampleList = examplelist;
        //todo creazione di una nuova ArrayList Item
        //mExampleListFull = new ArrayList<>(examplelist);

    }

    @Override
    public ExampleViewHolder onCreateViewHolder( ViewGroup parent , int view) {
        //todo creazione variabile View
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item_recyclerview,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    //Todo serve per riempire i campi di ViewHolder
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {

        Ticket currentItem = mExampleList.get(position);
        //Todo riempimento viewHolder

        holder.mTextticket.setText(Integer.toString(currentItem.getTicket()));
        holder.mTextredattore.setText(currentItem.getRedattore());
        holder.mTexttarga.setText(currentItem.getTarga());
        holder.mTextdataA.setText(Integer.toString(currentItem.getDataApertura()));
        holder.mTextmanutenzioneG.setText(currentItem.getMaterialeGuasto());
        holder.mTextdataC.setText(Integer.toString(currentItem.getDataChiusura()));

    }

    @Override
    public int getItemCount() {

         return mExampleList.size();
    }


    /*//todo procedura di implmentazione Filter
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }


    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Ticket> filterdArray = new ArrayList<>();

            if(constraint == null || constraint.length()== 0){
                filterdArray.addAll(mExampleListFull);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Ticket item : mExampleListFull){
                    //todo controlla i parametri di ricerca i ticket
                    if(item.getTicket().toLowerCase().contains(filterPattern)){
                        filterdArray.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterdArray;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            mExampleList.clear();
            mExampleList.addAll((List)results.values);
            notifyDataSetChanged();

        }
    };*/
}

