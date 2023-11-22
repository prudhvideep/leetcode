class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
         unordered_map <int,int> um;
        vector<int> v(2);
        for(int i=0;i<nums.size();i++)
        {
            um[nums[i]]=i;
        }
        for(int i=0;i<nums.size();i++)
        {
            if(um.find(target-nums[i]) != um.end() && i!=um[target-nums[i]])
            {
                v[0]=i;
                v[1]=um[target-nums[i]];
                break;
            }
        }
        return v;
    }
};