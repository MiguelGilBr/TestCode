package com.diktes.ducksearch.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.diktes.ducksearch.R;
import com.diktes.ducksearch.datamodel.dto.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder> {

    private static final String TAG = ResultsAdapter.class.getSimpleName();

    private Context mContext;
    private List<Result> mResults = new ArrayList<>();

    //CONSTRUCTOR
    public ResultsAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.result_row_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
//        Picasso.with(mContext).load(mResults.get(position).getFirstURL())
//                .into(viewHolder.getImageView());

        viewHolder.getTextViewInfo().setText(mResults.get(position).getText());
        viewHolder.getTextViewURL().setText(mResults.get(position).getFirstURL());
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public void setResults(List<Result> mResults) {
        this.mResults = mResults;
    }

    //VIEWHOLDER CLASS
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageViewIcon;
        private final TextView textViewURL;
        private final TextView textViewInfo;

        public ViewHolder(View v) {
            super(v);
            imageViewIcon = (ImageView) v.findViewById(R.id.result_image);
            textViewInfo = (TextView) v.findViewById(R.id.info);
            textViewURL = (TextView) v.findViewById(R.id.url);
        }

        //GETTERS
        public ImageView getImageView() {
            return imageViewIcon;
        }
        public TextView getTextViewURL() {
            return textViewURL;
        }
        public TextView getTextViewInfo() {
            return textViewInfo;
        }
    }

    //INTERFACE TO CONECT WITH ACTIVITY
    public interface IMovieCover {
        void onClick(int position);
    }
}