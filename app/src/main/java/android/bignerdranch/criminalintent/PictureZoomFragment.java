package android.bignerdranch.criminalintent;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.io.File;

public class PictureZoomFragment extends DialogFragment {

    private ImageView mPhotoView;
    private File mPhotoFile;
    private static final String ARG_PHOTO = "photoFile";

    //adding a new instance for the dialog fragment
    public static PictureZoomFragment newInstance(File photoFile) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO, photoFile);
        PictureZoomFragment fragment;
        fragment = new PictureZoomFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPhotoFile = (File) getArguments().getSerializable(ARG_PHOTO);
        View view = inflater.inflate(R.layout.dialog_image, container, false);
        mPhotoView = (ImageView) view.findViewById(R.id.imageView);
        if (mPhotoFile == null || !mPhotoFile.exists()) {
            mPhotoView.setImageDrawable(null);
        } else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(mPhotoFile.getPath(), getActivity());
            mPhotoView.setImageBitmap(bitmap);
        }

        return view;
    }
}

