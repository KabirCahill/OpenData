package a00878366.comp3717.bcit.ca.opendata;

import android.content.Context;

import a00878366.comp3717.bcit.ca.opendata.database.DatabaseHelper;

/**
 * Created by Kabir on 2/17/2017.
 */

public class DataLoader {

    static void init(final Context context)
    {
        final DatabaseHelper helper;
        final long           numCategoryEntries;
        final long           numDataSetEntries;

        helper = DatabaseHelper.getInstance(context);
        helper.openDatabaseForWriting(context);

        helper.deleteAllCategories();
        helper.deleteAllDataSets();

        numCategoryEntries = helper.getNumberOfCategories();
        numDataSetEntries = helper.getNumberOfDataSets();

        if(numCategoryEntries == 0) {
            helper.createCategory(0, "Business and Economy");
            helper.createCategory(1, "City Government");
            helper.createCategory(2, "Community");
            helper.createCategory(3, "Electrical");
            helper.createCategory(4, "Environment");
            helper.createCategory(5, "Finance");
            helper.createCategory(6, "Heritage");
            helper.createCategory(7, "Lands and Development");
            helper.createCategory(8, "Parks and Recreation");
            helper.createCategory(9, "Public Safety");
            helper.createCategory(10, "Transportation");
            helper.createCategory(11, "Utilities");
        }

        if(numDataSetEntries == 0) {
            // Business and Economy
            helper.createDataSet("Business Licenses (Active - Resident)","New Westminster has an annual renewal of approximately 4,000 business \n" +
                    "licenses each year. Business Licensing also issues licenses for liquor \n" +
                    "establishments and municipal decals.\n" +
                    "Things to know\n" +
                    "1) Before you sign a lease, it’s important for prospective business \n" +
                    "owners who are applying for business licenses to check with the Building, \n" +
                    "Planning and Licensing divisions on property they wish to lease or buy in \n" +
                    "regards to outstanding orders or issues pertaining to that property.\n" +
                    "2) Before you sign a lease, check with the Planning and Building \n" +
                    "Department to make sure your business is a permitted use on the site.\n" +
                    "3) Before you purchase a sign for your business, review the requirements \n" +
                    "of the sign bylaw with the Planning Division. Click here for Sign Permit \n" +
                    "information.\n" +
                    "4) Each space in a building has its own specific approved use and \n" +
                    "sometimes the use of that space cannot be changed without approval \n" +
                    "and/or permit.", 0);

            helper.createDataSet("Business Licenses (Inter-Municipal)", "As of October 1, 2013, an Inter-municipal Business License will be \n" +
                    "available in the Metro West region. For $250, eligible businesses may \n" +
                    "be licensed to work in all of the following municipalities:\n" +
                    "City of New Westminster City of Burnaby Corporation of Delta City \n" +
                    "of Richmond City of Surrey City of Vancouver\n" +
                    "Eligibility is limited to inter-municipal businesses, defined as trades \n" +
                    "contractors or other professionals (related to the construction industry) \n" +
                    "that provide a service or product other than from their fixed and \n" +
                    "permanent location. Only eligible businesses which have fixed and \n" +
                    "permanent location in one of the participating municipalities are \n" +
                    "eligible for the IMBL.\n" +
                    "For further information, please contact the City of New Westminster \n" +
                    "Business Licensing Office at 604-527-4565.", 0);

            helper.createDataSet("Business Licenses (New for 2016)", "Every business in the City of New Westminster is required to have a valid \n" +
                    "business license before beginning operation. This includes home-based \n" +
                    "businesses, commercial and industrial operations and owners of apartment \n" +
                    "rental properties.", 0);

            helper.createDataSet("Business Licenses (Non-Residents)", "Contractors from different municipalities doing business within \n" +
                    "New Westminster", 0);

            helper.createDataSet("Demographic - Detailed Age Profile (Census 2011)", "Census 2011 information summarized by ages (by individual years of age \n" +
                    "and age groupings) and gender, neighborhoods, census tracts and \n" +
                    "dissemination areas. Also contains descriptive information about the data \n" +
                    "source files and notes about the use of the data.", 0);

            helper.createDataSet("Demographic Profiles (Census 1986,1991,1996,2001,2006)", "Information for the City of New Westminster from the 1986, 1991, 1996, \n" +
                    "2001 and 2006 Censuses.\n" +
                    "This information includes age, housing characteristics, immigration, \n" +
                    "ethnicity, labour force, population change, income, education, household \n" +
                    "type, language information etc. Also contains descriptive information \n" +
                    "about the data source files and notes about the use of the data.", 0);

            helper.createDataSet("Demographic Profiles (Census 2011)", "2011 census information summarized by\n" +
                    "a) city b) neighborhoods c) census tracts and d) dissemination areas.\n" +
                    "Census information includes age, household type, family type, mother \n" +
                    "tongue, home language, type of dwelling etc. Also contains descriptive \n" +
                    "information about the data source files and notes about the use of the \n" +
                    "data.", 0);

            helper.createDataSet("Demographic Profiles (National Household Survey 2011)", "Contains tabs with 2011 National Household Survey information for the \n" +
                    "City of New Westminster, New Westminster neighbourhoods and New \n" +
                    "Westminster census tracts. National Household Survey includes information \n" +
                    "on income, housing characteristics, ethnicity, immigration, education, \n" +
                    "labour force etc. Also contains descriptive information about the data \n" +
                    "source files and notes about the use of the data.", 0);

            helper.createDataSet("Sidewalk Café Location (Sidewalk Encroachment Agreements)", "List of the locations of all Sidewalk Encroachment Agreements", 0);

            helper.createDataSet("Workforce - New West Resident Commuting Patterns (NHS 2011)", "This file contains information on the commuting patterns of workers who \n" +
                    "live in New Westminster (regardless of which municipality their place of \n" +
                    "work is located in). The information is from the 2011 National Household \n" +
                    "Survey and contains mode of transportation, time leaving for work, \n" +
                    "commute duration and commuting destinations. Also contains descriptive \n" +
                    "information about the data source files and notes about the use of the \n" +
                    "data.", 0);

            helper.createDataSet("Workforce - New West Worker Commuting Patterns (NHS 2011)", "Contains information on workers who work within the boundaries of the City \n" +
                    "of New Westminster (regardless of their municipality of residence).\n" +
                    "Information is from the 2011 National Household Survey and includes mode \n" +
                    "of transportation, time arriving at work, commute duration and commuting \n" +
                    "origin. Also contains descriptive information about the data source files \n" +
                    "and notes about the use of the data.", 0);

            helper.createDataSet("Workforce Profile (NHS 2011)", "2011 National Household Survey information on workers who work in New \n" +
                    "Westminster (regardless of municipality of residence). Information \n" +
                    "includes occupation, industry, employment income (before-tax), work \n" +
                    "activity, age and sex and education. Also contains descriptive \n" +
                    "information about the data source files and notes about the use of the \n" +
                    "data.", 0);





            // City Government
            helper.createDataSet("Addresses", "A list of addresses for the City of New Westminster.", 1);

            helper.createDataSet("City Boundaries", "City of New Westminster Boundaries.", 1);

            helper.createDataSet("City Owned Property", "Parcels of property currently owned by the Corporation of the City of \n" +
                    "New Westminster.", 1);

            helper.createDataSet("Councillor Contact Information", "The City of New Westminster wants to facilitate residents and the general \n" +
                    "public access to the elected officials of the City.", 1);

            helper.createDataSet("Election Results 1990 - Present", "The spreadsheet provides the candidates, voting locations and the results \n" +
                    "for the candidate both total and by location for each election from 1990 \n" +
                    "forward.", 1);

            helper.createDataSet("Neighbourhoods Boundaries", "These new boundaries are used for contemporary planning functions and are \n" +
                    "the basis for most of the statistics used in recent Census data published \n" +
                    "by the City of New Westminster. The boundaries for all neighbourhoods \n" +
                    "except for Downtown, North Arm North and Queens Park are the same for the \n" +
                    "redefined neighbourhood boundaries as in the original neighbourhood \n" +
                    "boundaries.", 1);

            helper.createDataSet("Number of City Employees", "Financial Disclosure form completed annual by all elected officials. \n" +
                    "Number of city employees by year.", 1);







            // Community
            helper.createDataSet("Cemeteries", "No Description Available", 2);

            helper.createDataSet("City Facility Sites", "No Description Available", 2);

            helper.createDataSet("Community Service Assets", "A listing of community services and supports. More specifically, it \n" +
                    "includes information on emergency, transitional and supportive housing; \n" +
                    "transition and second stage housing for women; addiction and mental \n" +
                    "health services; drop-in and meal programs; education and job training \n" +
                    "opportunities; and government services.", 2);

            helper.createDataSet("Public Art", "No Description Available", 2);

            helper.createDataSet("School Buildings", "No Description Available", 2);

            helper.createDataSet("School Catchment Boundaries", "Primary, Middle and Secondary School Boundaries.", 2);

            helper.createDataSet("School Sites", "No Description Available", 2);





            // Electrical
            helper.createDataSet("City Energy Use Through Time", "Financial disclosure form completed annually by all elected officials. \n" +
                    "Shows the amount of energy consumed and greenhouse gases created through \n" +
                    "time.", 3);

            // Environment
            helper.createDataSet("Riparian", "No Description Available", 4);


            // Finance
            helper.createDataSet("Grants (Awarded for 2016)", "A spreadsheet and accompanying documents listing grants awarded for \n" +
                    "year 2016.\n" +
                    "Grant Categories;\n" +
                    "1) Festival Event Grants \n" +
                    "2) Heritage Grants \n" +
                    "3) Environmental Grants \n" +
                    "4) Community Grants \n" +
                    "5) Arts and Culture Grants \n" +
                    "6) Child Care Grants \n" +
                    "6) City Partnership Grants \n" +
                    "7) Amateur Sports Grants", 5);

            helper.createDataSet("Schedule of Goods and Services (2015)", "Excel listing of all suppliers and service provides in the report period, \n" +
                    "plus the amount paid", 5);

            helper.createDataSet("Statement of Financial Information (2015)", "Remuneration of City Employees & Council Members", 5);





            // Heritage
            helper.createDataSet("Building Age", "The age of most buildings in the City (year it was built) as well as some \n" +
                    "historical data such as the Building Name, Developer/Builder, \n" +
                    "Architect/Designer and year the building has been moved if relevant and \n" +
                    "available.", 6);

            helper.createDataSet("Heritage Register", "Official listing of properties deemed to have heritage value.", 6);

            helper.createDataSet("Heritage Resource Inventory", "Complete unofficial listing of properties deemed to have heritage value, \n" +
                    "demolished and standing buildings", 6);





            // Land and Development
            helper.createDataSet("Block Reference File", "The blocks correspond to a division of the City into about 400 blocks, \n" +
                    "set up by the City Planner in about 1970. The purpose of these geographic\n" +
                    "descriptions was to enable more rapid tallying of information by subareas\n" +
                    "of the City. The geographic subdivision keys would provide easier \n" +
                    "selection of which properties to include in a run for a report without \n" +
                    "having to rely on property folio designations which are subject to \n" +
                    "change, consolidation and subdivision.\n" +
                    "Block reference file used with \"Historical Development Statistics\" and \n" +
                    "\"Landuse Percentages by Block\" datasets", 7);

            helper.createDataSet("Building Attributes", "Building development specifics including the number of floors above and below ground, the number of residential units, square footage, size of the footprint and site coverage, and address. ", 7);

            helper.createDataSet("Building Footprints", "Outlines of buildings. All primary buildings such as residential and \n" +
                    "commerical are included.", 7);

            helper.createDataSet("Community Conversation on Housing Comments (Our City 2014)", "Go to https://www.newwestcity.ca/ourcity for more details", 7);

            helper.createDataSet("Contours", "1 meter intervals", 7);

            helper.createDataSet("Historical Development Statistics", "Statistics per Hectare show a sample of four types of uses or content in \n" +
                    "a particular block/area; the number of residences, the number of \n" +
                    "buildings, the floor space ratio which is the ratio of a buildings total \n" +
                    "floor area to the size of the land upon which it is built, and the number \n" +
                    "of parking spaces on property in the area.\n" +
                    "Use in conjunction with the Block Reference Dataset.", 7);

            helper.createDataSet("Land Use", "Land use represents what a parcel of land is currently being used for \n" +
                    "(i.e., the land parcel’s primary use). The land use shown in this layer \n" +
                    "does not necessarily reflect the zoning or the OCP designation of the \n" +
                    "land.", 7);

            helper.createDataSet("Land Use Industrial", "Land use represents what a parcel of land is currently being used for \n" +
                    "(i.e., the land parcel’s primary use). The land use shown in this layer \n" +
                    "does not necessarily reflect the zoning or the OCP designation of the \n" +
                    "land.", 7);

            helper.createDataSet("Landuse Percentages by block", "The Landuse Percentages show what proportion of a block/area has a \n" +
                    "particular use (e.g., being used for Commercial purposes or Single Family \n" +
                    "Residences).\n" +
                    "Use in conjunction with the Block Reference Dataset", 7);

            helper.createDataSet("Orthophotography", "Aerial photography over the City of New Westminster", 7);

            helper.createDataSet("Parcel Blocks", "Block outlines of contiguous aggregated parcels.", 7);

            helper.createDataSet("Parcels", "No Description Available", 7);

            helper.createDataSet("Projects on the Go", "Current applications for rezoning, development permit and heritage \n" +
                    "revitalization agreement projects currently being processed by the City, \n" +
                    "including application status, architect/ developer information, and staff \n" +
                    "contact.", 7);

            helper.createDataSet("Survey Monuments", "For more information see Mascot at GeoBC Reference Systems and Survey Monuments.", 7);

            helper.createDataSet("Zoning", "The City of New Westminster Zoning Bylaw No. 6680 was adopted by Council \n" +
                    "September 17, 2001. Subsequent amendments to the Zoning Bylaw are \n" +
                    "consolidated for convenience only. For accurate interpretation, the \n" +
                    "public is encouraged to consult the Official Zoning Bylaw (including \n" +
                    "maps and amendments) available for viewing at City Hall in the Planning \n" +
                    "Division or Legislative Services Department.", 7);






            // Parks and Recreation
            helper.createDataSet("Accessible Public Washrooms", "Listing of all the accessible washrooms that are available within the City.", 8);

            helper.createDataSet("Bike Routes", "This dataset contains bike routes including planned and current bikeways, \n" +
                    "on-street and off-street, as well as dedicated lanes.", 8);

            helper.createDataSet("Drinking Fountains", "No Description Available", 8);

            helper.createDataSet("Greenways", "Greenways provide important cycling routes across the City connecting \n" +
                    "from one community to another and between major parks.", 8);

            helper.createDataSet("Off Leash Dog Areas", "No Description Available", 8);

            helper.createDataSet("Park Benches and Dedications", "Park benches locations throughout the city.\n" +
                    "Green: Undedicated benches Purple : Dedicated benches", 8);

            helper.createDataSet("Park Buildings", "Various buildings located on park property and used for multiple purposes.", 8);

            helper.createDataSet("Park Greenspaces", "No Description Available", 8);

            helper.createDataSet("Park Structures", "Park Structure data will include the structure name, structure type, \n" +
                    "quantity, monument dedication inscription, furnishing photo graph \n" +
                    "(as available) park name and/or location. The types of park structures \n" +
                    "included in the collection are \n" +
                    "• Bleachers \n" +
                    "• drinking fountains \n" +
                    "• Park Lighting \n" +
                    "• Monuments \n" +
                    "• Basketball hoops \n" +
                    "• Horticultural Planting Areas \n" +
                    "• Picnic Tables\n" +
                    "Monument dedication inscriptions were provided to the City for publically \n" +
                    "displayed on the monument, and as such the City has approval for the \n" +
                    "release. The inscription includes name, potentially a date range and \n" +
                    "inscription.", 8);

            helper.createDataSet("Park Trails", "No Description Available", 8);

            helper.createDataSet("Parks", "No Description Available", 8);

            helper.createDataSet("Playgrounds", "Includes the playgrounds within the parks in the City and the types of equipment available for play.", 8);

            helper.createDataSet("Sports Fields", "Sports Fields will include various types of activity fields including those used for softball, soccer, rugby, football, and lacrosse.", 8);

            helper.createDataSet("Tree Inventory - East", "Street trees do more than beautify our City and create community pride. \n" +
                    "Street trees have been scientifically proven to: save energy by reduce \n" +
                    "heating or cooling costs for buildings they cover calm traffic clean air \n" +
                    "filter dust absorb sound cool area under tree and absorb humidity provide \n" +
                    "habitats for birds, mammals and insects\n" +
                    "Parks staff select street trees based on established research to ensure \n" +
                    "the trees are viable without damaging public or private property and are \n" +
                    "resilient to disease and pests. Street trees generally have the following \n" +
                    "characteristics: Small to medium size (20 – 35 feet at maturity) Raised \n" +
                    "crown to provide maximum clearance between the sidewalk and lower \n" +
                    "branches Non-aggressive root systems Growth habits that are compatible \n" +
                    "with streetscapes (i.e. trees with upright growth habits are used in \n" +
                    "narrow spaces) Ornamental characteristics (i.e. bark, fall colour, \n" +
                    "flowers, etc.) that enhance the neighbourhood.", 8);

            helper.createDataSet("Tree Inventory - West", "Street trees do more than beautify our City and create community pride. \n" +
                    "Street trees have been scientifically proven to: save energy by reduce \n" +
                    "heating or cooling costs for buildings they cover calm traffic clean air \n" +
                    "filter dust absorb sound cool area under tree and absorb humidity provide \n" +
                    "habitats for birds, mammals and insects\n" +
                    "Parks staff select street trees based on established research to ensure \n" +
                    "the trees are viable without damaging public or private property and are \n" +
                    "resilient to disease and pests. Street trees generally have the following \n" +
                    "characteristics: Small to medium size (20 – 35 feet at maturity) Raised \n" +
                    "crown to provide maximum clearance between the sidewalk and lower \n" +
                    "branches Non-aggressive root systems Growth habits that are compatible \n" +
                    "with streetscapes (i.e. trees with upright growth habits are used in \n" +
                    "narrow spaces) Ornamental characteristics (i.e. bark, fall colour, \n" +
                    "flowers, etc.) that enhance the neighbourhood.", 8);





            // Public Safety
            helper.createDataSet("Emergency Incidents By Fire Hall", "Emergency incident types by year by hall. The total of yearly calls is \n" +
                    "also represented.", 9);

            helper.createDataSet("Emergency Incidents By Fire Hall Summary", "Emergency incident summary counts for past five years by hall. The total \n" +
                    "monthly and yearly calls are represented.", 9);

            helper.createDataSet("Emergency Incidents by Type (Fire and Rescue Services)", "Incident types by month/year. The total and percentage of incidents of \n" +
                    "total calls is also represented. Only the current year is available \n" +
                    "in .csv.", 9);

            helper.createDataSet("Fire and Rescue Services Buildings", "No Description Available", 9);

            helper.createDataSet("Fire Incidents by Year", "Fire incidents by year. The total number of incidents is broken down into \n" +
                    "reportable to the Office of the Fire Commissioner and non reportable.", 9);

            helper.createDataSet("Hospital Buildings", "No Description Available", 9);

            helper.createDataSet("Oil Tanks (Removed/Decommissioned)", "The number of underground storage tanks that are active, removed, or \n" +
                    "outstanding in the removal process, by year.", 9);

            helper.createDataSet("Police Buildings", "No Description Available", 9);




            // Transportation
            helper.createDataSet("Alternative Fuels and Electric Charging Stations", "Electric vehicles are an environmentally friendly mode of transportation. As cleaner emission vehicles gain momentum across the lower mainland, the City of New Westminster is putting itself on the map alongside leading municipalities by incorporating electric vehicles into the City's automotive fleet and installing electric vehicle charging stations in the community.\n" +
                    "\n" +
                    "For a map of EV charging stations and their availability, visit Go Electric Stations.", 10);

            helper.createDataSet("Bike Routes", "This dataset contains bike routes including planned and current bikeways, on-street and off-street, as well as dedicated lanes.", 10);

            helper.createDataSet("Bus Routes", "Bus Routes within New Westminster.", 10);

            helper.createDataSet("Bus Stops", "Bus Stop locations within New Westminster noting which are accessible.", 10);

            helper.createDataSet("ICBC Crash Data", "Lower mainland crashes\n" +
                    "See how many crashes are happening at intersections in New Westminster \n" +
                    "and around the Lower Mainland.", 10);

            helper.createDataSet("Intersections", "The junctions at-grade of two or more roads either meeting or crossing.", 10);

            helper.createDataSet("Parking Pay Stations", "Identifies the locations of all multi-space digital pay stations for \n" +
                    "parking in the City.", 10);

            helper.createDataSet("Railways", "No Description Available", 10);

            helper.createDataSet("Regulatory Signs", "Regulatory street signs which also include Do Not Enter and 3 and 4 Way tabs.", 10);

            helper.createDataSet("School Walking Routes", "Walking to school promotes healthy and safe communities benefiting children, families, and the earth.", 10);

            helper.createDataSet("SkyTrain Centreline", "No Description Available", 10);

            helper.createDataSet("SkyTrain Stations", "SkyTrain Stations within New Westminster shown as footprints of the structure shapes.", 10);

            helper.createDataSet("SkyTrain Stations Points", "SkyTrain Stations within New Westminster shown as point locations.", 10);

            helper.createDataSet("Speed Signs", "These street signs include Speed Signs and Speed Tabs.", 10);

            helper.createDataSet("Street Features", "No Description Available", 10);

            helper.createDataSet("Street Names", "List of all current in-use street names used within the City.", 10);

            helper.createDataSet("Street Network", "Street centerlines and road classification", 10);

            helper.createDataSet("Traffic Controllers/Signals", "No Description Available", 10);

            helper.createDataSet("Traffic Volumes", "Traffic volume counts at midblock points between the years 2006 and 2016 inclusive.", 10);

            helper.createDataSet("Truck Routes", "No Description Available", 10);

            helper.createDataSet("Warning Signs", "Warning Street Signs include Object Markers, Playground Ahead, Speed Bumps, Neighbourhood Speed Humps, No Exits, School Areas, and Misc Warning Signs.", 10);

            helper.createDataSet("Webcam Links", "Active webcam locations in New Westminster.", 10);

            helper.createDataSet("Wheelchair Ramps", "No Description Available", 10);







            // Utilities
            helper.createDataSet("Drinking Fountains", "", 11);

            helper.createDataSet("Sewer Catchbasins", "", 11);

            helper.createDataSet("Sewer Culverts", "", 11);

            helper.createDataSet("Sewer Ditches", "", 11);

            helper.createDataSet("Sewer Mains", "", 11);

            helper.createDataSet("Sewer Maintenance Holes", "", 11);

            helper.createDataSet("Water Hydrants", "A hydrant is an outlet from a fluid main often consisting of an upright pipe with a valve attached from which fluid (e.g. water or fuel) can be tapped.", 11);

            helper.createDataSet("Water Pressure Zones", "This polygon feature class represents each water pressure zone in the City of New Westminster water distribution system. The data was developed to represent the location of water pressure zones for the purpose of mapping, analysis, planning and maintenance of utilities. The accuracy of this data varies and should not be used for precise measurements or calculations.", 11);

            helper.createDataSet("Water Quality Data", "A hydrant is an outlet from a fluid main often consisting of an upright \n" +
                    "pipe with a valve attached from which fluid (e.g. water or fuel) can be \n" +
                    "tapped. This data set presents the raw data from which our Annual Water \n" +
                    "Quality report is generated. For full context for the data please refer \n" +
                    "to the report.\n" +
                    "NWR Comp 2015.xlsm - Monthly bacteriological analysis of portable water \n" +
                    "samples\n" +
                    "NWR Numbers 2015.xlsm - Monthly samples for coliform bacteria\n" +
                    "NWR By-station 2015.xlsm - Full year water quality testing by station \n" +
                    "(addresses given are locations of the sampling station)\n" +
                    "NWR HPC 2015.xlsm - Monthly heterotrophic plate count\n" +
                    "NWR 4Q DBP.xlsm - 4th quarter disinfectant by product reports", 11);

            helper.createDataSet("Water Valves", "A device that regulates the flow of water.", 11);

            helper.createDataSet("Watermains", "A principal pipe in a system of pipes for conveying water, especially one installed underground.", 11);
        }

        helper.close();
    }
}
