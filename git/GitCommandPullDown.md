
--global to update pc details
git config user.name "PMcDevitt"
git config user.email "pmcde@allstate.com"

git remote -v
git remote rm origin // remove
git remote add origin https://PMcDevitt@github.com/PMcDevitt/rpn-calculator.git
git config master.remote origin
git config master.merge refs/heads/master
