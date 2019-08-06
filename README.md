# Presto Plus (Demo App)

Architechture followed : "MVVM" (Res:https://medium.com/upday-devs/android-architecture-patterns-part-3-model-view-viewmodel-e7eeee76b73b)

MVVM combines the advantages of separation of concerns provided by MVP, while leveraging the advantages of data bindings. The result is a pattern where the model drives as many of the operations as possible, minimizing the logic in the view.
View is just a consumer of the ViewModel, it is easier to just replace different UI elements, with minimal, or sometimes zero changes in other classes.
Separation of concerns is important and that we should split the code more, creating small Views and small ViewModels that only have specific responsibilities. The ViewModels are injected in the Views. This means that most of the times, we just add the Views in the XML UI, without doing any other changes. Therefore, when our UI requirements change again, we can easily replace some Views with new ones.
P.S - It is really satisfying to now have to write findviewbyid() method again and again among other benifits.

Key Points :-
1) Implemented "MVVM" along with "LiveData" library. Since livedata library is android lifecycle friendly, we dont have to remove and start new observers on "onResume" and "onPause" methods.
2) Wrote some unit tests.
3) Background is the best i could get in a short splan of time
4) Animations can improve the user experience a great deal.
5) Since there was no actual API consumption, had to mimick the effect by using Handle and Runnable.
6) Min Supported SDK -> 18 (Jellybean)
7) Max Supported SDK -> 28 (Pie, Since Q is not yet fully stable or released)
8) Lottie library for image animations
9) Acitivity supports potrait mode only which is more suited to restaurant apps signup activity.
10) Lottie image animation continuous loop may interfere with the Unit Test written.
