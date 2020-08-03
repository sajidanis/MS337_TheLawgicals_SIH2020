<template>
    <div >
        <AppBar />
        <SideBar :navItems="managerNavItems"  />
        <v-main app>
            <v-container>
                <router-view></router-view>
            </v-container>
        </v-main>
        <Footer />
    </div>
</template>

<script>
import SideBar from '@/dashboard/layout/SideBar.vue'
import AppBar from '@/dashboard/layout/AppBar.vue'
import Footer from '@/dashboard/layout/Footer.vue'

export default {
    name: 'ManagerIndex',
    components: {
        SideBar,
        AppBar,
        Footer,
    },
    data() {
        return {
            managerNavItems: [
                {
                    title: 'Submit Evidence',
                    icon: ' ',
                    route: { name: 'AddBidder' },
                },
                {
                    title: 'View All Evidence',
                    icon: '',
                    route: { name: 'SuspendedBidder' },
                },
                {
                    title: 'Evidence Drafts',
                    icon: ' ',
                    route: { name: 'ViewAll' },
                },
                {
                    title: 'Resubmit Evidence',
                    icon: '',
                    route: { name: 'PendingForReview' },
                },
                {
                    title: 'Back To Stakeholders Dashboard',
                    icon: 'fa-home',
                    route: '/dashboard',
              },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
