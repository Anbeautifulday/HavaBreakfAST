package so.go2.sharingthegym.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

import so.go2.sharingthegym.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BottmFirstFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BottmFirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottmFirstFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottm_first, container, false);
        return view;
    }




}
