package apps.yoo.com.blockholdings.ui.watchlist.all;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import apps.yoo.com.blockholdings.R;
import apps.yoo.com.blockholdings.data.models.Object_Coin;
import apps.yoo.com.blockholdings.util.Constants;
import apps.yoo.com.blockholdings.util.Message;


public class RVAdapter_SearchSuggestions extends RecyclerView.Adapter<RVAdapter_SearchSuggestions.YoloCartViewHolder>{
    private List<Object_Coin> listOfitems ;
    private Context context ;

    public RVAdapter_SearchSuggestions(Context context, List<Object_Coin> listOfitems) {
        this.context = context ;
        this.listOfitems = listOfitems ;
    }

    @Override
    public YoloCartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_watchlist_search_suggestions,parent,false) ;
        return new YoloCartViewHolder(convertView) ;
    }


    @Override
    public void onBindViewHolder(final YoloCartViewHolder holder, final int position) {
        final Object_Coin currentItem = listOfitems.get(position) ;

        Glide.with(context).load(Constants.URL_PREFIX_IMAGELOGO + currentItem.getSymbol().toUpperCase() + ".png").into(holder.imageView_Link) ;
        holder.textView_Name.setText(currentItem.getName());
        holder.textView_Symbol.setText(currentItem.getSymbol());

        holder.relativeLayout_Container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, Activity_Detail.class) ;
//                intent.putExtra("coinId", currentItem.getId()) ;
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) ;
//                ((Activity) context).finish();
                Message.display(context, "Clicked on " + currentItem.getName());
            }
        });


    }

    public void refreshData(List<Object_Coin> newListOfItems){
        this.listOfitems = newListOfItems ;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return Math.min(listOfitems.size(), 6);
//        return listOfitems.size();
    }

    public class YoloCartViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout relativeLayout_Container ;
        TextView textView_Name, textView_Symbol ;
        ImageView imageView_Link ;

        public YoloCartViewHolder(View itemView) {
            super(itemView);
            relativeLayout_Container= (RelativeLayout) itemView.findViewById(R.id.singleRowCoinSelector_RelativeLayout_Main) ;
            textView_Name = (TextView) itemView.findViewById(R.id.singleRowCoinSelector_TextView_CoinName) ;
            textView_Symbol = (TextView) itemView.findViewById(R.id.singleRowCoinSelector_TextView_CoinSymbol) ;
            imageView_Link = (ImageView) itemView.findViewById(R.id.singleRowCoinSelector_ImageView_CoinImage) ;

        }
    }
}

