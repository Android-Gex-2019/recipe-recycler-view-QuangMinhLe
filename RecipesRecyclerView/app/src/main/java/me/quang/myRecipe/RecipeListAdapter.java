package me.quang.myRecipe;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.quang.myRecipe.R;

import java.util.LinkedList;

//Author: Quang Le

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private final LinkedList<Recipe> recipeList;
    private LayoutInflater inflater;
    private Context context;

    public RecipeListAdapter(Context context, LinkedList<Recipe> recipeList) {
        inflater = LayoutInflater.from(context);
        this.recipeList = recipeList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = inflater.inflate(R.layout.recipelist_item, parent, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        Recipe current = recipeList.get(position);
        holder.recipeTitleView.setText(current.name);
        holder.recipeDescriptionView.setText(current.description);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView recipeTitleView;
        public final TextView recipeDescriptionView;
        final RecipeListAdapter myAdapter;

        public RecipeViewHolder(View itemView, RecipeListAdapter adapter) {
            super(itemView);
            recipeTitleView = itemView.findViewById(R.id.title);
            recipeDescriptionView = itemView.findViewById(R.id.description);
            this.myAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, RecipeDetails.class);
            intent.putExtra("position", getAdapterPosition());
            view.getContext().startActivity(intent);
        }
    }
}
