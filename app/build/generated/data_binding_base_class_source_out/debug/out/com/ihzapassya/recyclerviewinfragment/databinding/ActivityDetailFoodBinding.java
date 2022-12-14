// Generated by view binder compiler. Do not edit!
package com.ihzapassya.recyclerviewinfragment.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ihzapassya.recyclerviewinfragment.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDetailFoodBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView foodImage;

  @NonNull
  public final TextView foodInformation;

  @NonNull
  public final TextView foodName;

  @NonNull
  public final View line1;

  private ActivityDetailFoodBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView foodImage, @NonNull TextView foodInformation, @NonNull TextView foodName,
      @NonNull View line1) {
    this.rootView = rootView;
    this.foodImage = foodImage;
    this.foodInformation = foodInformation;
    this.foodName = foodName;
    this.line1 = line1;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailFoodBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailFoodBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_detail_food, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailFoodBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.food_image;
      ImageView foodImage = rootView.findViewById(id);
      if (foodImage == null) {
        break missingId;
      }

      id = R.id.food_information;
      TextView foodInformation = rootView.findViewById(id);
      if (foodInformation == null) {
        break missingId;
      }

      id = R.id.food_name;
      TextView foodName = rootView.findViewById(id);
      if (foodName == null) {
        break missingId;
      }

      id = R.id.line1;
      View line1 = rootView.findViewById(id);
      if (line1 == null) {
        break missingId;
      }

      return new ActivityDetailFoodBinding((ConstraintLayout) rootView, foodImage, foodInformation,
          foodName, line1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
