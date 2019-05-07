package com.evgeniy.moiseev.testtask;

import android.animation.ValueAnimator;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.evgeniy.moiseev.testtask.data.model.Person;
import com.evgeniy.moiseev.testtask.data.model.Persons;
import com.evgeniy.moiseev.testtask.data.model.Post;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String SLUG = "BMTJ7hn5IWaT";

    private LinearLayout mLinearLayoutLikers;
    private LinearLayout mLinearLayoutCommentators;
    private LinearLayout mLinearLayoutMentions;
    private LinearLayout mLinearLayoutReposts;
    private TextView mTextViewViewsCount;
    private TextView mTextViewLikersCount;
    private TextView mTextViewCommentatorsCount;
    private TextView mTextViewMentionsCount;
    private TextView mTextViewRepostsCount;
    private TextView mTextViewBookmarksCount;

    private LayoutInflater mInflater;
    private InRatingApi mApi;
    private MutableLiveData<Post> mPost;


    private Observer<Post> postObserver = new Observer<Post>() {
        @Override
        public void onChanged(Post post) {
            if (post != null) {
                getSupportActionBar().setTitle("Slug = " + SLUG);

                mTextViewViewsCount.setText(getResources().getString(R.string.views_count, String.valueOf(post.getViewsCount())));
                mTextViewBookmarksCount.setText(getResources().getString(R.string.bookmarks_count, String.valueOf(post.getBookmarksCount())));

                mApi.getLikers(post.getId(), 1).enqueue(mLikersCallback);
                mApi.getCommentators(post.getId(), 1).enqueue(mCommentatorsCallback);
                mApi.getMentions(post.getId(), 1).enqueue(mMentionsCallback);
                mApi.getReposts(post.getId(), 1).enqueue(mRepostsCallback);

            }
        }
    };
    private Callback<Post> mPostCallback = new Callback<Post>() {
        @Override
        public void onResponse(Call<Post> call, Response<Post> response) {
            mPost.setValue(response.body());
        }

        @Override
        public void onFailure(Call<Post> call, Throwable t) {

        }
    };

    private Callback<Persons> mLikersCallback = new Callback<Persons>() {
        @Override
        public void onResponse(Call<Persons> call, Response<Persons> response) {
            Persons persons = response.body();
            mTextViewLikersCount.setText(getResources().getString(R.string.likers_count, String.valueOf(persons.getMeta().getTotal())));
            if (persons.getMeta().getTotal() != 0) {
                resizeCardView((CardView) findViewById(R.id.cardViewLikers));
                List<Person> personList = persons.getData();
                for (Person person : personList) {
                    View view = mInflater.inflate(R.layout.avatar_layout, mLinearLayoutLikers, false);
                    ((TextView) view.findViewById(R.id.textViewNickname)).setText(person.getNickname());
                    Glide.with(MainActivity.this)
                            .load(person.getAvatarImage()
                                    .getUrlMediumOrigin())
                            .into((ImageView) view.findViewById(R.id.imageViewAvatar));
                    mLinearLayoutLikers.addView(view);
                }
                if (persons.getMeta().getTotal() > persons.getMeta().getPerPage()) {
                    for (int i = 2; i <= persons.getMeta().getLastPage(); i++) {
                        mApi.getLikers(mPost.getValue().getId(), i).enqueue(mLikersDownloadCallback);
                    }
                }
            }
        }

        @Override
        public void onFailure(Call<Persons> call, Throwable t) {

        }
    };
    private Callback<Persons> mLikersDownloadCallback = new Callback<Persons>() {
        @Override
        public void onResponse(Call<Persons> call, Response<Persons> response) {
            downloadThumbnails(response, mLinearLayoutLikers);
        }

        @Override
        public void onFailure(Call<Persons> call, Throwable t) {
        }

    };

    private Callback<Persons> mCommentatorsCallback = new Callback<Persons>() {
        @Override
        public void onResponse(Call<Persons> call, Response<Persons> response) {
            Persons persons = response.body();
            mTextViewCommentatorsCount.setText(getResources().getString(R.string.commentators_count, String.valueOf(persons.getMeta().getTotal())));
            if (persons.getMeta().getTotal() != 0) {
                resizeCardView((CardView) findViewById(R.id.cardViewCommentators));
                List<Person> personList = persons.getData();
                for (Person person : personList) {
                    View view = mInflater.inflate(R.layout.avatar_layout, mLinearLayoutCommentators, false);
                    ((TextView) view.findViewById(R.id.textViewNickname)).setText(person.getNickname());
                    Glide.with(MainActivity.this)
                            .load(person.getAvatarImage()
                                    .getUrlMedium())
                            .into((ImageView) view.findViewById(R.id.imageViewAvatar));
                    mLinearLayoutCommentators.addView(view);
                }
                if (persons.getMeta().getTotal() > persons.getMeta().getPerPage()) {
                    for (int i = 2; i <= persons.getMeta().getLastPage(); i++) {
                        mApi.getCommentators(mPost.getValue().getId(), i).enqueue(mCommentatorsDownloadCallback);
                    }
                }
            }
        }

        @Override
        public void onFailure(Call<Persons> call, Throwable t) {

        }
    };
    private Callback<Persons> mCommentatorsDownloadCallback = new Callback<Persons>() {
        @Override
        public void onResponse(Call<Persons> call, Response<Persons> response) {
            downloadThumbnails(response, mLinearLayoutCommentators);
        }

        @Override
        public void onFailure(Call<Persons> call, Throwable t) {
        }

    };

    private Callback<Persons> mMentionsCallback = new Callback<Persons>() {
        @Override
        public void onResponse(Call<Persons> call, Response<Persons> response) {
            Persons persons = response.body();
            mTextViewMentionsCount.setText(getResources().getString(R.string.mentions_count, String.valueOf(persons.getMeta().getTotal())));
            if (persons.getMeta().getTotal() != 0) {
                resizeCardView((CardView) findViewById(R.id.cardViewMentions));
                List<Person> personList = persons.getData();
                for (Person person : personList) {
                    View view = mInflater.inflate(R.layout.avatar_layout, mLinearLayoutMentions, false);
                    ((TextView) view.findViewById(R.id.textViewNickname)).setText(person.getNickname());
                    Glide.with(MainActivity.this)
                            .load(person.getAvatarImage()
                                    .getUrlMedium())
                            .into((ImageView) view.findViewById(R.id.imageViewAvatar));
                    mLinearLayoutMentions.addView(view);
                }
                if (persons.getMeta().getTotal() > persons.getMeta().getPerPage()) {
                    for (int i = 2; i <= persons.getMeta().getLastPage(); i++) {
                        mApi.getMentions(mPost.getValue().getId(), i).enqueue(mMentionsDownloadCallback);
                    }
                }
            }
        }

        @Override
        public void onFailure(Call<Persons> call, Throwable t) {

        }
    };
    private Callback<Persons> mMentionsDownloadCallback = new Callback<Persons>() {
        @Override
        public void onResponse(Call<Persons> call, Response<Persons> response) {
            downloadThumbnails(response, mLinearLayoutMentions);
        }

        @Override
        public void onFailure(Call<Persons> call, Throwable t) {
        }

    };

    private Callback<Persons> mRepostsCallback = new Callback<Persons>() {
        @Override
        public void onResponse(Call<Persons> call, Response<Persons> response) {
            Persons persons = response.body();
            mTextViewRepostsCount.setText(getResources().getString(R.string.reposts_count, String.valueOf(persons.getMeta().getTotal())));
            if (persons.getMeta().getTotal() != 0) {
                resizeCardView((CardView) findViewById(R.id.cardViewReposts));
                List<Person> personList = persons.getData();
                for (Person person : personList) {
                    View view = mInflater.inflate(R.layout.avatar_layout, mLinearLayoutReposts, false);
                    ((TextView) view.findViewById(R.id.textViewNickname)).setText(person.getNickname());
                    Glide.with(MainActivity.this)
                            .load(person.getAvatarImage()
                                    .getUrlMedium())
                            .into((ImageView) view.findViewById(R.id.imageViewAvatar));
                    mLinearLayoutReposts.addView(view);
                }
                if (persons.getMeta().getTotal() > persons.getMeta().getPerPage()) {
                    for (int i = 2; i <= persons.getMeta().getLastPage(); i++) {
                        mApi.getReposts(mPost.getValue().getId(), i).enqueue(mRepostsDownloadCallback);
                    }
                }
            }
        }

        @Override
        public void onFailure(Call<Persons> call, Throwable t) {

        }
    };
    private Callback<Persons> mRepostsDownloadCallback = new Callback<Persons>() {
        @Override
        public void onResponse(Call<Persons> call, Response<Persons> response) {
            downloadThumbnails(response, mLinearLayoutReposts);
        }

        @Override
        public void onFailure(Call<Persons> call, Throwable t) {
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        mLinearLayoutLikers = findViewById(R.id.linearLayoutLikers);
        mLinearLayoutCommentators = findViewById(R.id.linearLayoutCommentators);
        mLinearLayoutMentions = findViewById(R.id.linearLayoutMentions);
        mLinearLayoutReposts = findViewById(R.id.linearLayoutReposts);
        mTextViewViewsCount = findViewById(R.id.textViewViewsCount);
        mTextViewLikersCount = findViewById(R.id.textViewLikesCount);
        mTextViewCommentatorsCount = findViewById(R.id.textViewCommentatorsCount);
        mTextViewMentionsCount = findViewById(R.id.textViewMentionsCount);
        mTextViewRepostsCount = findViewById(R.id.textViewRepostsCount);
        mTextViewBookmarksCount = findViewById(R.id.textViewBookmarksCount);

        mInflater = LayoutInflater.from(this);
        mApi = RetrofitClient.getInstance().getApi();
        mPost = new MutableLiveData<>();

        mApi.getPost(SLUG).enqueue(mPostCallback);
        mPost.observe(this, postObserver);
    }

    private void resizeCardView(final CardView cardView) {
        final ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) cardView.getLayoutParams();
        ValueAnimator animator = ValueAnimator.ofInt(params.height, (int) (100 * getResources().getDisplayMetrics().density));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                params.height = (int) animation.getAnimatedValue();
                cardView.setLayoutParams(params);
            }
        });
        animator.start();
    }

    private void downloadThumbnails(Response<Persons> response, LinearLayout layout) {
        Persons persons = response.body();
        List<Person> personList = persons.getData();
        for (Person person : personList) {
            View view = mInflater.inflate(R.layout.avatar_layout, layout, false);
            ((TextView) view.findViewById(R.id.textViewNickname)).setText(person.getNickname());
            Glide.with(MainActivity.this)
                    .load(person.getAvatarImage()
                            .getUrlMediumOrigin())
                    .into((ImageView) view.findViewById(R.id.imageViewAvatar));
            layout.addView(view);
        }
    }
}
