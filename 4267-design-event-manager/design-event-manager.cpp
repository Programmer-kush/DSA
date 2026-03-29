class EventManager {
public:
    struct Compare {
        bool operator()(const pair<int, int>& a, const pair<int, int>& b) {
            // First compare priorities (Max-Heap behavior)
            if (a.first != b.first) {
                return a.first < b.first;
            }
            // If priorities equal, smaller ID wins (Min-Heap behavior for second element)
            return a.second > b.second;
        }
    };

    // Data members
    priority_queue<pair<int, int>, vector<pair<int, int>>, Compare> pq;
    unordered_map<int, int> currentP;

    EventManager(vector<vector<int>>& events) {
        for (auto& event : events) {
            int id = event[0];
            int priority = event[1];
            currentP[id] = priority;
            pq.push({priority, id});
        }
    }

    void updatePriority(int eventId, int newPriority) {
        // Update the "source of truth" map and push the new version to PQ
        currentP[eventId] = newPriority;
        pq.push({newPriority, eventId});
    }

    int pollHighest() {
        while (!pq.empty()) {
            pair<int, int> top = pq.top();
            pq.pop();

            int p = top.first;
            int id = top.second;

            // Lazy Deletion: Only process if this version matches our map
            if (currentP.count(id) && currentP[id] == p) {
                currentP.erase(id); // Remove from map as it's no longer active
                return id;
            }
        }
        return -1;
    }
};