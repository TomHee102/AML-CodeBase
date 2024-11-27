/* eslint-disable no-unused-vars */
import React, { useEffect, useState } from 'react';
import '../MediaTransferForm.css';
import { listMedia } from '../services/MediaService';

function MediaTransferForm() {
    const [media, setMedia] = useState([]);
    const [branches, setBranches] = useState([]); // State for branches
    const [selectedMedia, setSelectedMedia] = useState(null);
    const [fromBranchId, setFromBranchId] = useState('');
    const [toBranchId, setToBranchId] = useState('');
    const [message, setMessage] = useState('');

    // Fetch media and branches when the component mounts
    useEffect(() => {
        // Fetch media data
        listMedia().then((response) => {
            setMedia(response.data);
            console.log('Fetched Media Data:', response.data);
        }).catch((error) => {
            console.error('Error fetching media:', error);
        });

        // Fetch branches (Assuming you have an API endpoint for branches)
        fetch('http://localhost:8080/api/branch')
            .then(response => response.json())
            .then(data => {
                setBranches(data);
                console.log('Fetched Branches Data:', data);
            })
            .catch((error) => {
                console.error('Error fetching branches:', error);
            });
    }, []);

    const handleSelectMedia = (mediaItem) => {
        console.log('Selected Media:', mediaItem); // Check if branch_id is correctly set
        setSelectedMedia(mediaItem);
        setFromBranchId(mediaItem.branch_id);  // Set fromBranchId based on selected media's branch_id
        setToBranchId(''); // Reset To Branch selection
    };
    

    // Handle media transfer (local logic)
    const handleTransfer = (e) => {
        e.preventDefault();
        setMessage('');

        console.log('From Branch ID:', fromBranchId); // Debug log
        console.log('To Branch ID:', toBranchId); 

        if (!selectedMedia || !fromBranchId || !toBranchId) {
            setMessage('Please select media and provide both branch IDs.');
            return;
        }

        const fromBranch = branches.find(branch => branch.id === parseInt(fromBranchId, 10));
        const toBranch = branches.find(branch => branch.id === parseInt(toBranchId, 10));

        // Validate that both branches have the same City
        if (fromBranch?.City !== toBranch?.City) {
            setMessage('The selected branches must be in the same city.');
            return;
        }

        // Simulate the transfer locally by updating media's branch_id
        const updatedMedia = media.map(item => 
            item.id === selectedMedia.id ? { ...item, branch_id: parseInt(toBranchId, 10) } : item
        );

        setMedia(updatedMedia);
        setMessage('Media transferred successfully!');
        setFromBranchId('');
        setToBranchId('');
        setSelectedMedia(null);
    };

    // Debugging: log the branch name based on fromBranchId
    const fromBranch = branches.find(branch => branch.id === parseInt(fromBranchId, 10)); // Ensure correct comparison
    const fromBranchName = fromBranch ? fromBranch.branchname : 'N/A'; // Use 'N/A' if no matching branch is found

    return (
        <div className="Media_Transfer">
            <h2>Media Transfer</h2>

           
            {!selectedMedia ? (
                <div>
                    <p>Please select a media to transfer.</p>
                    <select
                        value={selectedMedia ? selectedMedia.id : ''}
                        onChange={(e) => {
                            const selected = media.find(item => item.id === parseInt(e.target.value, 10));
                            handleSelectMedia(selected);
                        }}
                    >
                        <option value="">Select Media</option>
                        {media.map((item) => (
                            <option key={item.id} value={item.id}>
                                {item.title} (ID: {item.id})
                            </option>
                        ))}
                    </select>
                </div>
            ) : (
                <>
                  
                    <form onSubmit={handleTransfer}>
                        <div className="form-group">
                            <label>Media ID:</label>
                            <input
                                type="text"
                                value={selectedMedia.id}
                                readOnly
                            />
                        </div>

                  
                        <div className="form-group">
                            <label>From Branch:</label>
                            <input
                                type="text"
                                value={fromBranchName}
                                readOnly
                            />
                        </div>

                       
                        <div className="form-group">
                            <label>To Branch:</label>
                            <select
                                value={toBranchId}
                                onChange={(e) => setToBranchId(e.target.value)}
                                required
                            >
                                <option value="">Select To Branch</option>
                                {branches.map((branch) => (
                                    <option key={branch.id} value={branch.id}>
                                        {branch.branchname} (ID: {branch.id})
                                    </option>
                                ))}
                            </select>
                        </div>

                        <button type="submit" className="transfer-button">Transfer Media</button>
                    </form>
                    <button onClick={() => setSelectedMedia(null)} className="cancel-button">
                        Cancel
                    </button>
                </>
            )}

       
            {message && <p className="message">{message}</p>}
        </div>
    );
}

export default MediaTransferForm;
