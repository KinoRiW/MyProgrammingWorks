/*
AtCoder Beginner Contest 210 E - Ring MST
URL : https://atcoder.jp/contests/abc210/tasks/abc210_e
time : 40min
*/

#include <iostream> // cout, endl, cin
#include <algorithm> // min, max, swap, sort, reverse, lower_bound, upper_bound
#include <vector> //vector
using namespace std;
#define _LIBCPP_DEBUG 0
#define rep(i, n) for(int i = 0; i < (int)n; i++)
typedef long long ll;

int gcd(int a, int b) {
    if (b==0) return a;
    else return gcd(b, a%b);
}

int main(){
    int n, m;
    cin >> n >> m;
    int g = n;
    vector<pair<int, int> > ca(m);

    rep(i, m){
        int a, c;
        cin >> a >> c;
        ca.at(i).first = c;
        ca.at(i).second = a;
        g = gcd(g, a);
    }

    if(g != 1){
        cout << -1 << endl;
        return 0;
    }

    g = n;
    ll res = 0;

    sort(ca.begin(), ca.end());

    rep(i, m){
        int a = ca.at(i).second;
        int c = ca.at(i).first;

        int gb = gcd(g, a);
        res += (ll)(g - gb) * c;
        g = gb;

        if(g == 1){
            cout << res << endl;
            return 0;
        }
    }
}