Did not change to much from the peer review handin. The main part is that I have made a few more classes in the view to
make some classes less responsible and smaller. This caused some coupling issues though so I made an observer in the view
to get rid of circular dependency.

Looking at my project now with the knowledge from working with ws3 and the lessons regarding patterns I see that the solution is far from
optimal and very complicated but I decided not to scrap everything since I still think it is ok from reading the requiremnts for the task.

One bug was found in the reviews which I have fixed. I saved the social security number in an int before and then when the number was above
2300000000 or something it will be to big for an int so I changed it to hold a long instead.

Other main thing I changed from the reviews was to make my inputControl class smaller. Before the inputControl held the member and boatActions aswell,
they have separate classes.

Fun exercise!